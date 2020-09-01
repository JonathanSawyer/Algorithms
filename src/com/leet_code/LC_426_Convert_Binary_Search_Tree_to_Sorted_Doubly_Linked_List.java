package com.leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

import com.leet_code.models.TreeNode;

public class LC_426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {
    public static void main(String[] args) {
//                 2
//                / \
//               1   4
//                  / \
//                 3   5

        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);

        n2.left = n1;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;

        TreeNode treeNode = treeToDoublyList(n2);
    }

    public static TreeNode treeToDoublyList(TreeNode root) {
        Deque<TreeNode> res = new ArrayDeque<>();
        helper(root, res);
        TreeNode head = new TreeNode(0);
        TreeNode curr = head;
        TreeNode prev = null;
        while (!res.isEmpty()) {
            TreeNode nxt = res.removeFirst();
            helper(nxt.right, res);
            curr.left = prev;
            curr.right = nxt;
            prev = curr;
            curr = nxt;
        }
        curr.right = head.right;
        head.right.left = curr;
        return head;
    }

    public static void helper(TreeNode node, Deque<TreeNode> res) {
        if (node == null) {
            return;
        }
        res.addFirst(node);
        helper(node.left, res);
    }
}
