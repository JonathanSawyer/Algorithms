package com.neat_coder;

import com.neat_coder.models.TreeNode;

public class LC_108_Convert_Sorted_Array_to_Binary_Search_Tree_Recursive {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) { return null; }
        TreeNode head = constructRecursively(nums, 0, nums.length - 1);
        return head;
    }

    private static TreeNode constructRecursively(int[] nums, int start, int end) {
        if (start > end) { return null; }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructRecursively(nums, start, mid - 1);
        node.right = constructRecursively(nums, mid + 1, end);
        return node;
    }

    public static void run() {
        TreeNode treeNode = sortedArrayToBST(new int[] { 3, 5, 7, 10, 15, 17, 20, 30 });
    }
}
