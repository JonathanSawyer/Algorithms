package com.neat_coder;

import java.util.Deque;
import java.util.LinkedList;

import com.neat_coder.models.TreeNode;

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

        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();

            if(n1 == null && n2 == null) { continue;}
            if(n1 == null || n2 == null) { return false;}

            if(n1.val != n2.val) {
                return false;
            }

            q.add(n1.left);
            q.add(n2.right);

            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
}
