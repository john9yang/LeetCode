package tree;

/**
 * 找出二叉树中路径最大的和
 */

public class Test4 {
    /**
     * 求a,b,c的最大值
     */
    int max(int a,int b,int c){
        int max = a>b ? a : b;
        max = max > c ? max : c;
        return max;
    }

    /**
     * 找出最长路径
     */
    public int findMaxPathRecursive(TreeNode root,IntRef max){
        if( root == null ){
            return 0;
        }
        else {
            //求左子树以root.left为起始点的最大路径和
            int sumLeft = findMaxPathRecursive(root.left,max);
            //求右子树以root.right为起始点的最大路径和
            int sumRight = findMaxPathRecursive(root.right,max);
            //求以root为起始点,叶子结点为结束点的最大路径和
            int allMax = root.val+sumLeft+sumRight;
            int lefMax = root.val+sumLeft;
            int rightMax = root.val+sumRight;
            int tmpMax = max(allMax,lefMax,rightMax);
            if ( tmpMax > max.val )
                max.val = tmpMax;
            int subMax = sumLeft>sumRight?sumLeft:sumRight;
            //返回以root为起始终点，叶子结点为结束终点的最大路径和
            return root.val+subMax;
        }
    }

    public int findMaxPath(TreeNode root){
        IntRef maxRef = new IntRef();
        maxRef.val = Integer.MIN_VALUE;
        findMaxPathRecursive(root,maxRef);
        return maxRef.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(5);

        root.left = left;
        root.right = right;

        Test4 test4 = new Test4();
        System.out.println(test4.findMaxPath(root));
    }
}
