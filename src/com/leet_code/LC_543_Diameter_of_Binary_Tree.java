package com.leet_code;

import static java.lang.System.out;

import com.leet_code.models.TreeNode;

public class LC_543_Diameter_of_Binary_Tree {
    public static void run() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t2.left = t3;
        t2.right = t5;
        t1.right = t4;

        //        1
        //       / \
        //      2   4
        //     / \
        //    3  5

        out.println(diameterOfBinaryTree(t1));
    }

    public static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public static int maxDepth(TreeNode node) {
        if (node == null) { return 0; }
        out.println("===");
        int left = maxDepth(node.left);
        out.println(node.left != null ? node.left.val : "");
        int right = maxDepth(node.right);
        out.println(node.right != null ? node.right.val : "");
        max = Math.max(max, left + right);
        int i = Math.max(left, right) + 1;
        out.println("L:" + left + " max:" + i);
        out.println("R:" + right + " max:" + i);
        out.println("===");
        return i;
    }
}

//        1
//       / \
//      2   4
//     / \
//    3  5
