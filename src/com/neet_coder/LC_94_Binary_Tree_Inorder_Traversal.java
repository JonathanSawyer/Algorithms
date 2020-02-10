package com.neet_coder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.neet_coder.models.TreeNode;

public class LC_94_Binary_Tree_Inorder_Traversal {
    public static void run() {
        final TreeNode n10 = new TreeNode(10);
        final TreeNode n11 = new TreeNode(11);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode nminus1 = new TreeNode(-1);
        final TreeNode n16 = new TreeNode(16);
        final TreeNode n10_2 = new TreeNode(10);
        final TreeNode n9 = new TreeNode(9);
        final TreeNode n11_2 = new TreeNode(11);

        n10.left = n11;
        n11.left = n2;
        n11.right = nminus1;
        n10.right = n16;
        n16.left = n10_2;
        n10_2.left = n9;
        n10_2.right = n11_2;

        //inorderTraversal(n10);
        inorderTraversal(n10);
        //          10
        //         /  \
        //       11    16
        //      /  \   /
        //     2   -1 10
        //           / \
        //          9  11

        // 2, 11, -1, 10, 9, 10, 11, 16
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, result);
            }

            result.add(root.val);

            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }
}
