package com.leet_code;

import com.leet_code.models.TreeNode;

public class LC_104_Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n5.left = n3;
        n3.left = n2;
        n2.left = n1;
        n5.right = n6;
        n3.right = n4;

//         5
//        / \
//       3   6
//      / \
//     2   4
//    /
//   1
        int i = maxDepth(n5);
        System.out.print(i);
    }

    public static int current = -1;

    public static int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        return helper(root);
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

}
