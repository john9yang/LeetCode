package linklist;

public class ReverseTest1 {

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
        reverse(head);
        for( cur = head.next;cur!=null;cur = cur.next )
            System.out.print(cur.data+" ");
    }

    public static void reverse(LNode head){
        if ( head == null || head.next == null )
            return;

        LNode cur; //当前节点
        LNode next; //后继节点
        LNode pre;  //前置节点

        //将头结点的后续节点置为尾节点
        cur = head.next;
        next = cur.next;
        cur.next = null;
        pre = cur;
        cur = next;

        while( cur.next != null ){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //将尾节点放入第一个节点
        head.next = cur;
        cur.next =pre;
    }
}
