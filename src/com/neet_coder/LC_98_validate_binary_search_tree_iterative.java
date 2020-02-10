package com.neet_coder;

import java.util.LinkedList;

import com.neet_coder.models.TreeNode;

public class LC_98_validate_binary_search_tree_iterative {

    private static LinkedList<TreeNode> stack = new LinkedList<>();
    private static LinkedList<Integer> lower = new LinkedList<>();
    private static LinkedList<Integer> upper = new LinkedList<>();

    public static void run() {
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
        update(node, min, max);
        while (!stack.isEmpty()) {
            TreeNode n = stack.poll();
            Integer l = lower.poll();
            Integer h = upper.poll();

            if (n == null) {continue;}
            if (l != null && l >= n.val) {return false;}
            if (h != null && h <= n.val) {return false;}
            update(n.left, min, n.val);
            update(n.right, n.val, max);
        }
        return true;
    }

    public static void update(TreeNode node, Integer l, Integer h) {
        stack.add(node);
        lower.add(l);
        upper.add(h);
    }

    public static boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
}
