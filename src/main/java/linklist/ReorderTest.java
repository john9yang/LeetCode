package linklist;

public class ReorderTest {
    /**
     * 找出链表head的中间结点,把链表从中间段成两个子链表
     * @param head 链表头结点
     * @return 链表中间结点
     */
    private static LNode findMiddileNode( LNode head ){
        if ( head == null || head.next == null )
            return head;

        LNode fast = head; //遍历链表时每次向前走两步
        LNode slow = head; //遍历链表时每次相前走一步
        LNode preSlow = head;
        //当fast到链表尾部时,slow恰好指向链表的中间结点
        while( fast != null && fast.next != null ){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //把链表断开成两个独立的子链表
        preSlow.next = null;
        return slow;
    }

    /**
     * 对不带头结点的单链表翻转
     * @param head 链表头结点
     */
    private static LNode reversed( LNode head ){
        if ( head == null || head.next == null )
            return head;

        LNode pre = head;   //前驱结点
        LNode cur = head.next; //当前结点
        LNode next;    //后继结点

        pre.next = null;
        //使当前遍历到的结点cur指向其前驱结点
        while( cur != null ){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 对链表进行重排序
     * @param head 链表头结点
     */
    public static void reorder( LNode head ){
        if ( head == null || head.next == null || head.next.next == null )
            return;
        //前半部分第一个结点
        LNode cur1 = head.next;
        LNode mid = findMiddileNode( head.next );
        //后半部分链表逆序后的第一个结点
        LNode cur2 = reversed( mid );
        LNode tmp;
        //合并两个链表
        while( cur1.next != null ){
            tmp = cur1.next;
            cur1.next = cur2;
            cur1 = tmp;

            tmp = cur2.next;
            cur2.next = cur1;
            cur2 = tmp;
        }

        cur1.next = cur2;
    }

    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        //构造链表
        for (int i = 1; i < 8; i++) {
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("排序前: ");
        for( cur = head.next;cur != null;cur = cur.next ){
            System.out.print( cur.data + " " );
        }
        System.out.println();
        reorder( head );
        System.out.println("重排序后: ");
        for( cur = head.next;cur != null;cur = cur.next ){
            System.out.print( cur.data + " " );
        }

//        System.out.println("倒叙后:");
//        LNode reversedHead = reversed(head.next);
//        for( cur = reversedHead;cur != null;cur = cur.next ){
//            System.out.print( cur.data + " " );
//        }

//        LNode middle = findMiddileNode( head );
//        System.out.println("中间结点: "+ middle.data );
    }

}
