package linklist;

public class MergeList {

    //链表结点
    private class Node{
        int data;
        Node right,down;
        Node( int data ){
            this.data = data;
            this.right = right;
            this.down = down;
        }
    }

    private Node head;

    /**
     * 用来合并两个有序的链表
     */
    private Node merge(Node a,Node b){
        //如果其中一个为空,直接返回另外一个链表
        if ( a == null )
            return b;

        if ( b == null )
            return a;

        //把两个链表头中较小的结点赋值给result
        Node result;
        if( a.data  < b.data ){
            result = a;
            result.down = merge(a.down,b);
        }
        else{
            result = b;
            result.down = merge(a,b.down);
        }

        return result;
    }

    /**
     * 链表扁平化处理
     */
    public Node flatten( Node root ){
        if ( root == null || root.right == null )
            return root;
        //递归处理root.right链表
        root.right = flatten( root.right );
        //把root结点对应的链表与右边的链表合并
        root = merge(root,root.right);

        return root;
    }

    /**
     * 把data插入链表头
     */
    private Node insert( Node head_ref, int data ){
        Node new_node = new Node( data );
        new_node.down = head_ref;
        head_ref = new_node;
        //返回新的表头结点
        return head_ref;
    }

    public void pringList(){
        Node temp = head;
        while( temp != null ){
            System.out.print(temp.data+" ");
            temp = temp.down;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeList ml = new MergeList();

        //构造链表
        ml.head = ml.insert(ml.head,31);
        ml.head = ml.insert(ml.head,8);
        ml.head = ml.insert(ml.head,6);
        ml.head = ml.insert(ml.head,3);

        ml.head.right = ml.insert(ml.head.right,21);
        ml.head.right = ml.insert(ml.head.right,11);

        ml.head.right.right = ml.insert(ml.head.right.right,50);
        ml.head.right.right = ml.insert(ml.head.right.right,22);
        ml.head.right.right = ml.insert(ml.head.right.right,15);

        ml.head.right.right.right = ml.insert(ml.head.right.right.right,55);
        ml.head.right.right.right = ml.insert(ml.head.right.right.right,40);
        ml.head.right.right.right = ml.insert(ml.head.right.right.right,39);
        ml.head.right.right.right = ml.insert(ml.head.right.right.right,30);

        //扁平化链表
        ml.head = ml.flatten(ml.head);
        ml.pringList();
    }
}