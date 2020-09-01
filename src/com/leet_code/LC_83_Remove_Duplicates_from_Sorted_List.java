package com.leet_code;

import com.leet_code.models.ListNode;

public class LC_83_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(1);
        ListNode ln3 = new ListNode(1);
        ListNode ln4 = new ListNode(2);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        deleteDuplicates(ln1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
