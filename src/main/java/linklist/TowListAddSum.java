package linklist;

public class TowListAddSum {

    public static LNode add(LNode h1, LNode h2) {
        if (h1 == null || h1.next == null)
            return h2;

        if (h2 == null|| h2.next == null)
            return h1;

        //carry over bit
        int c = 0;
        int sum = 0;
        LNode p1 = h1.next;
        LNode p2 = h2.next;
        LNode tmp = null;
        LNode resultHead = new LNode();
        resultHead.next = null;
        LNode p = resultHead;

        while(p1 != null && p2 != null) {
            tmp = new LNode();
            tmp.next = null;
            sum = p1.data + p2.data + c;
            tmp.data = sum % 10;
            c = sum / 10;
            p.next = tmp;
            p = tmp;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null) {
            while(p2 != null) {
                tmp = new LNode();
                tmp.next = null;
                sum = p2.data + c;
                tmp.data = sum % 10;
                c = sum / 10;
                p.next = tmp;
                p = tmp;
                p2 = p2.next;
            }
        }

        if (p2 == null) {
            while(p1 != null) {
                tmp = new LNode();
                tmp.next = null;
                sum = p1.data + c;
                tmp.data = sum % 10;
                c = sum / 10;
                p.next = tmp;
                p = tmp;
                p1 = p1.next;
            }
        }

        if (c == 1) {
            tmp = new LNode();
            tmp.next = null;
            tmp.data = 1;
            p.next = tmp;
        }

        return resultHead;
    }
}
