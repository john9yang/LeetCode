package com.jhclass.leetcode.rotaterightlist2;

import java.sql.SQLOutput;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || n < 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;
        ListNode q = root;

        int count = 0;
        for (int i = 0; i <=n; i++) {
            p = p.next;
            count++;
            if (p == null) {
                count--; // 链表中除头结点后数据个数
                n = n % count; // 实际要位置的位数
                // 为重新开始位移做准备
                i = 0;
                p = head;
            }
        }

        // 找到第一个要交换的结点的前驱
        // q为第一个要交换的结点的前驱
        while (p != null) {
            p = p.next;
            q = q.next;

        }

        p = q;
        q = root;
        if (p != null && p.next != null) { // 有要位移的结点
            ListNode node;
            while (p.next != null) {
                // 摘除结点
                node = p.next;
                p.next = node.next;
                // 接上结点
                node.next = q.next;
                q.next = node;
                q = node; // 最后一个移动的节点
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
//        ListNode header = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

//        header.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        Solution solution = new Solution();

        ListNode  resultNode = solution.rotateRight(node1,2);
        while(resultNode.next!=null){
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println(resultNode.val);
    }
}