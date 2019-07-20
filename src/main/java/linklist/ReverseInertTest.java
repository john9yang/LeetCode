package linklist;

public class ReverseInertTest {

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

//        System.out.println("After reverse with head:");
        ReverseInertTest test = new ReverseInertTest();
//        test.reverseHead(head);
//        for( cur = head.next;cur!=null;cur = cur.next )
//            System.out.print(cur.data+" ");

        System.out.println("After reverse with no head:");
        LNode first;
        first = head.next;
        head.next = null;
        LNode newFirst = test.reverse(first);
        for( cur = newFirst;cur!=null;cur = cur.next )
            System.out.print(cur.data+" ");
    }

    public void reverseHead(LNode head){
        //空链表直接返回
        if ( head == null || head.next == null )
            return;

        LNode cur; //当前节点
        LNode next; //后续节点
        cur = head.next.next;
        //将第一个节点置为尾节点
        head.next.next = null;
        while( cur != null ){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
    }

    public LNode reverse(LNode first){
        if ( first == null || first.next == null )
            return null;

        LNode cur,next;

        cur = first.next;
        first.next = null;

        while( cur != null ){
            next = cur.next;
            cur.next = first;
            first = cur;
            cur = next;
        }

        return first;
    }
}
