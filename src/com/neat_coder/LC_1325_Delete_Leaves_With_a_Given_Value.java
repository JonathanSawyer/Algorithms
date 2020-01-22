package com.neat_coder;

import com.neat_coder.models.TreeNode;

public class LC_1325_Delete_Leaves_With_a_Given_Value {
    public static void run() {
        TreeNode root = newNode(10);
        root.left = newNode(3);
        root.right = newNode(10);
        root.left.left = newNode(3);
        root.left.right = newNode(3);
        root.right.right = newNode(3);
        root.right.right.left = newNode(3);
        root.right.right.right = newNode(4);

        removeLeafNodes(root, 3);
    }

    static TreeNode newNode(int data) {
        TreeNode newNode = new TreeNode(data);
        newNode.left = null;
        newNode.right = null;
        return (newNode);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        // terminating condition of our recursion
        if (root == null) { return null; }

        // add these items to the stack
        root.left = removeLeafNodes(root.left, target);

        // add these items to the stack
        root.right = removeLeafNodes(root.right, target);

        // start at the end of the recursive calls.
        if (root.left == null && root.right == null && root.val == target) { return null; }

        return root;
    }
}
