package com.company;

import com.company.models.TreeNode;

public class LC_101_symmetric_tree_iterative {

    public static void run() {
        //       1
        //      / \
        //     2    2
        // null 3 null,3
        //
        //
        //
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);

        left.left = null;
        left.right = new TreeNode(3);
        node.left = left;

        right.left = null;
        right.right = new TreeNode(3);
        node.right = right;

        System.out.println(isSymmetric(node));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
    }
}
