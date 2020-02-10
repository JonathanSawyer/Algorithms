package com.neet_coder;

import java.util.HashSet;

import com.neet_coder.models.ListNode;

public class LC_160_Intersection_of_Two_Linked_Lists_HashSet {
    public static void run() {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode headARec = headA;
        ListNode headBRec = headB;
        while (headARec != null) {
            set.add(headARec);
            headARec = headARec.next;
        }

        while (headBRec != null) {
            if (set.contains(headBRec)) {
                return headBRec;
            }
            set.add(headBRec);
            headBRec = headBRec.next;
        }
        return null;
    }
}
