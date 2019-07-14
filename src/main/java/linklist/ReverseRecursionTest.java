package linklist;

public class ReverseRecursionTest {
    //逆序不带头结点的链表
    public LNode reverse(LNode node){
        //链表没有节点或者只有一个节点
        if ( node == null || node.next == null )
            return node;

        //将当前节点添加到逆序节点的尾部
        LNode newFirst = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newFirst;
    }

    //逆序带头结点的链表
    public LNode reverseHead(LNode head){
        LNode newFirst = reverse(head.next);
        head.next = newFirst;

        return head;
    }

    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;

        for( int i=0; i<10; i++ ){
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;

            cur.next = tmp;
            cur = tmp;
        }

        System.out.println("Before reverse:");
        for( cur = head.next;cur!=null;cur = cur.next )
            System.out.print(cur.data+" ");
        System.out.println();

        System.out.println("After reverse:");
        ReverseRecursionTest test = new ReverseRecursionTest();
        LNode newHeader = test.reverseHead(head);
        for( cur = newHeader.next;cur!=null;cur = cur.next )
            System.out.print(cur.data+" ");
    }
}
