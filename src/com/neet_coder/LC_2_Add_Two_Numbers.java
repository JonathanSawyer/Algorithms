package com.neet_coder;

import com.neet_coder.models.ListNode;

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.
public class LC_2_Add_Two_Numbers {
    public static void run() {
        ListNode l1 = new ListNode(6);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(5);

        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(5);

//        l1.next = l2;
//        l2.next = l3;
//
//        l4.next = l5;
//        l5.next = l6;

        ListNode listNode = addTwoNumbers(l1, l4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinal = new ListNode(-1);
        ListNode result = sentinal;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            sum %= 10;
            result.next = new ListNode(sum);
            result = result.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry > 0) {
            result.next = new ListNode(carry);
        }
        return sentinal.next;
    }
}
