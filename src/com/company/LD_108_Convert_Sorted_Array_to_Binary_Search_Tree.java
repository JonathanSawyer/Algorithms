package com.company;

import java.util.LinkedList;
import java.util.Queue;

public final class LD_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
//        final int centerPoint = nums.length % 2;
//        final int centerPosition = nums.length / 2;
//        TreeNode root;
//        final int rootIndex = centerPoint != 0 ? centerPosition : centerPosition - 1;
//
//        root = new TreeNode(nums[rootIndex]);
//        TreeNode head = root;
//
//        for (int index = rootIndex - 1; index >= 0; index--) {
//            root.left = new TreeNode(nums[index]);
//            root = root.left;
//        }
//
//        root = head;
//        for (int index = nums.length - 1; index > rootIndex; index--) {
//            root.right = new TreeNode(nums[index]);
//            root = root.right;
//        }
//
//        return head;

        if(nums == null || nums.length == 0) {
            return null;
        }

        return constructBSTRecursive(nums, 0, nums.length - 1);

    }

    private static TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        final int mid = left + (right - left) / 2;
        final TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBSTRecursive(nums, left, mid -1);
        current.right = constructBSTRecursive(nums, mid + 1, right);
        return current;
    }

    public static void run() {
        TreeNode treeNode = sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
        printLevelOrder(treeNode);
    }

    static void printLevelOrder(TreeNode root) {
        if (root == null) { return; }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0) { break; }
            while (nodeCount > 0) {
                TreeNode node = q.peek();
                System.out.print(node.val + " ");
                q.remove();
                if (node.left != null) { q.add(node.left); }
                if (node.right != null) { q.add(node.right); }
                nodeCount--;
            }
            System.out.println();
        }
    }
}
