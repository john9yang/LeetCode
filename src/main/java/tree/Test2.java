package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    /**
     * 对二叉树进行镜像反转
     */
    public static void reverseTree(BiTNode root){
        if ( root == null )
            return;

        reverseTree(root.lchild);
        reverseTree(root.rchild);

        BiTNode tmp = root.lchild;
        root.lchild = root.rchild;
        root.rchild = tmp;
    }

    public static BiTNode arrayToTree(int[] arr,int start,int end){
        BiTNode root = null;

        if ( end >= start ){
             root = new BiTNode();
             int mid = (start+end+1)/2;
             //树的根结点为数组中间的元素
            root.data = arr[mid];
            //递归地用左半部分数组构造root的左子树
            root.lchild = arrayToTree(arr,start,mid-1);
            //递归地用右半部分数组构造root的右子树
            root.rchild = arrayToTree(arr,mid+1,end);
        }
        else
            root = null;

        return root;
    }

    public static void printTreeLayer(BiTNode root){
        if( root == null )
            return;

        BiTNode p;
        Queue<BiTNode> queue = new LinkedList<>();
        //树根结点进队列
        queue.offer(root);
        while(queue.size()>0){
            p = queue.poll();
            //访问当前结点
            System.out.print(p.data+" ");
            //如果这个结点的左孩子不为空入队列
            if( p.lchild != null )
                queue.offer(p.lchild);
            //如果这个结点的右孩子不为空入队列
            if(p.rchild != null )
                queue.offer(p.rchild);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        BiTNode root;
        root = arrayToTree(arr,0,arr.length-1);
        System.out.println("二叉树层序遍历结果:");
        printTreeLayer(root);
        reverseTree(root);
        System.out.println("二叉树反转后层序遍历结果:");
        printTreeLayer(root);
    }
}
