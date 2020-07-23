package com.leet_code;

import com.leet_code.models.ListNode;

public class LC_24_Swap_Nodes_in_Pairs {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode = swapPairs(listNode1);
        while (listNode != null) {
            System.out.print(listNode.val + "-");
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
