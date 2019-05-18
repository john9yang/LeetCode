package com.jhclass.leetcode.rotaterightlist;

import java.util.Stack;

public class ListNode {
      public int val;

      public ListNode next;

      public ListNode(int x) {
          val = x;
      }

}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
           if ( head == null )
               return null;

           int len = lenOf( head );
           if ( len < 2 || k == len || k < 1 )
               return head;

           if ( k > len )
               k = k % len;

           ListNode p  = head;
           //找到要移动的节点的前驱
           for ( int i = 0 ; i < len-k-1; i++ ){
               p = p.next;
           }

           ListNode q  = p;
           p = p.next;
           Stack<Integer> stack = new Stack<Integer>();
           while( p != null ){
               stack.push(p.val);
               p = p.next;
           }

           q.next = null;

           while( stack.size() > 0 ){
               ListNode n = new ListNode(stack.pop());
               n.next = head;
               head = n;
           }

           return head;
    }

    private int lenOf(ListNode head)
    {
        ListNode p = head;
        int len = 0;
        while(p != null){
            len ++;
            p = p.next;
        }
        return len;
    }
}