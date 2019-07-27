package linklist;

public class RemoveDuplicateRecursionTest {

    private static LNode removeDupRecurision(LNode head){
       if ( head.next == null )
           return head;

       LNode pointer = null;
       LNode cur = head;
       //对以head.next为首的子链表删除重复的结点
        head.next = removeDupRecurision(head.next);
        pointer = head.next;

        //找出以head.next为首的子链表中与head结点相同的结点并删除
        while( pointer != null ){
            if ( head.data == pointer.data ){
                cur.next = pointer.next;
                pointer = cur.next;
            }
            else {
                pointer = pointer.next;
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 对带头结点的单链表删除重复结点
     */
    public static void removeDup( LNode head ){
        if ( head == null )
            return;
        head.next = removeDupRecurision(head.next);
    }

    public static void main(String[] args) {
        int i = 1;
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;

        for ( ; i < 7; i++) {
            tmp = new LNode();
            if ( i%2 == 0 )
                tmp.data = i+1;
            else if ( i%3 == 0 ){
                tmp.data = i-2;
            }
            else
                tmp.data = 1;

            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }

        System.out.println("删除重复结点之前:");
        for( cur = head.next; cur!=null ; cur=cur.next ){
            System.out.print(cur.data+" ");
        }

        removeDup(head);

        System.out.println();
        System.out.println("删除重复结点之后:");
        for( cur = head.next; cur!=null ; cur=cur.next ){
            System.out.print(cur.data+" ");
        }
    }
}