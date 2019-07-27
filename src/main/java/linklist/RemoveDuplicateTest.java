package linklist;

public class RemoveDuplicateTest {
    /**
     * 对带头结点的无序单链表删除重复的节点
     */
    public static void removeDup(LNode head){

        if ( head == null || head.next == null )
            return;

        LNode outerCur = head.next;   //用于外层循环，指向链表第一个节点
        LNode innerCur = null;  //内层循环用来遍历outerCur后面的结点
        LNode innerPre = null;  //innerCur的前驱结点

        for( ; outerCur != null ; outerCur=outerCur.next){
            for( innerCur = outerCur.next,innerPre=outerCur;innerCur != null;  ){
                //找到重复的结点并删除
                if ( outerCur.data == innerCur.data ){
                    innerPre.next = innerCur.next;
                    innerCur = innerCur.next;
                }
                else {
                    innerPre = innerCur;
                    innerCur = innerCur.next;
                }
            }
        }
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