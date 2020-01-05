package com.company;

import com.company.models.TreeNode;

public class LC_98_validate_binary_search_tree_recursive {
    public static void run() {
//        final TreeNode n1 = new TreeNode(1);
//        final TreeNode n1_1 = new TreeNode(1);
//        n1.left  = n1_1;



        final TreeNode n20 = new TreeNode(20);
        final TreeNode n30 = new TreeNode(30);
        final TreeNode n10 = new TreeNode(10);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n15 = new TreeNode(15);
        final TreeNode n17 = new TreeNode(17);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n7 = new TreeNode(7);

        n20.right = n30;
        n20.left = n10;

        n10.right = n15;
//        n15.right = n17;

        n10.left = n5;
//        n5.left = n3;
//        n5.right = n7;

        boolean validBST = isValidBST(n20);
    }

    public static boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min) {
            return false;
        }

        if (max != null && node.val >= max) {
            return false;
        }

        if (!isBST(node.left, min, node.val)) {
            return false;
        }

        if (!isBST(node.right, node.val, max)) {
            return false;
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
}
