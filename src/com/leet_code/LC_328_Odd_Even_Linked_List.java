package com.leet_code;

import com.leet_code.models.ListNode;

public class LC_328_Odd_Even_Linked_List {
    public static void run() {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = new ListNode(2);
        final ListNode l3 = new ListNode(3);
        final ListNode l4 = new ListNode(4);
        final ListNode l5 = new ListNode(5);
        final ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = oddEvenList(l1);
//        Input: 1->2->3->4->5->NULL
//        Output: 1->3->5->2->4->NULL
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        final ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
