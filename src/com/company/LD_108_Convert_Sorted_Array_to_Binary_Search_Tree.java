package com.company;

import java.util.LinkedList;
import java.util.Queue;

import com.company.models.TreeNode;

public final class LD_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length - 1;
        int mid = (length / 2) + (length % 2);
        TreeNode head = new TreeNode(nums[mid]);
        TreeNode left = head;
        TreeNode right = head;

        for(int index = mid - 1; index >= 0; index--) {
            left.left = new TreeNode(nums[index]);
            left = left.left;
        }

        if(nums.length > 2) {
            right.right = new TreeNode(nums[nums.length - 1]);
            right = right.right;
            for (int index = nums.length - 2; index > mid; index--) {
                right.left = new TreeNode(nums[index]);
                right = right.left;
            }
        }
        return head;
    }

    public static void run() {
        TreeNode treeNode1 = sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
        TreeNode treeNode2 = sortedArrayToBST(new int[] { 0 });
        printLevelOrder(treeNode2);
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
