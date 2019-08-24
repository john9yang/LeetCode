package linklist;

public class SpecificDeletionTest {

    public static void printList(LNode head){
        for( LNode cur = head.next; cur!=null ;cur=cur.next ){
            System.out.print(cur.data+" ");
        }
    }

    /**
     * 方法功能: 给定单链表中某个结点，删除该结点
     * 输入参数: 链表中某结点
     * 返回值: true : 删除成功 false: 删除失败
     */
    public static boolean removeNode(LNode p){
        //如果结点为空,或结点p无后继结点,则无法删除
        if ( p == null || p.next == null )
            return false;

        p.data = p.next.data;
        LNode tmp = p.next;
        p.next = tmp.next;

        return true;
    }

    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        LNode p = null;

        for( int i=0; i<10; i++ ){
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;

            cur.next = tmp;
            cur = tmp;

            if ( i ==5 )
                p = tmp;
        }
        System.out.println("删除前:");
        printList(head);
        boolean flag = removeNode(p);
        if ( flag ){
            System.out.println();
            System.out.println("删除后:");
            printList(head);
        }
    }
}