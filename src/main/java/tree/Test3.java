package tree;

/**
 * 在二叉排序树种找出第一个大于中间值的结点
 */
public class Test3 {
    /**
     * 查找值最小的结点
     * @param root 根结点
     * return 值最小的结点
     */
    private static BiTNode getMinNode(BiTNode root){
        if ( root == null )
            return root;

        while( root.lchild != null )
            root = root.lchild;
        return root;
    }

    /**
     * 查找值最大的结点
     * @param root 根结点
     * return 值最大的结点
     */
    private static BiTNode getMaxNode(BiTNode root){
        if( root == null )
            return root;

        while( root.rchild != null )
            root = root.rchild;

        return root;
    }

    public static BiTNode getNode( BiTNode root ){
        BiTNode maxNode = getMaxNode(root);
        BiTNode minNode = getMinNode(root);
        int mid = (maxNode.data+minNode.data)/2;
        BiTNode result = null;

        while( root != null ){
            //当前结点的值不大于mid,则在右子树上找
            if( root.data <= mid ){
                root = root.rchild;
            }
            //否则在左子树上找
            else{
                result = root;
                root = root.lchild;
            }
        }

        return result;
    }

    public static BiTNode arrayToTree(int[] arr,int start,int end){
        BiTNode root = null;
        if ( end >= start ){
            root = new BiTNode();
            int mid = (start+end+1)/2;
            //树的根结点为数组中间的元素
            root.data = arr[mid];
            //递归地用左半部分数组构造root的左子树
            root.lchild = arrayToTree(arr, start, mid-1);
            //递归地用右半部分数组构造root的右子树
            root.rchild = arrayToTree(arr,mid+1,end);
        }
        else{
            root = null;
        }

        return root;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        BiTNode root;
        root = arrayToTree(arr,0,arr.length-1);

        System.out.println(getNode(root).data);
    }
}
