package com.leet_code;

import com.leet_code.models.ListNode;

public class LC_142 {
    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n3.next = n2;
        n2.next = n0;
        n0.next = n4;
        n4.next = n2;

        System.out.println(detectCycle(n3).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode t = head.next;
        ListNode h = head.next.next;

        while(t != null && h != null && h.next != null && h != t ) {
            t = t.next;
            h = h.next.next;
        }

        if(t != h) {
            return null;
        }

        h = head;
        while(t != h) {
            h = h.next;
            t = t.next;
        }
        return h;
    }
}
