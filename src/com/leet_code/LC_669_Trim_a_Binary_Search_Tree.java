package com.leet_code;

import com.leet_code.models.TreeNode;

public class LC_669_Trim_a_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        TreeNode treeNode = trimBST(n1, 1, 2);
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if (root.val < low) {
            root = trimBST(root.right, low, high);
        } else if (root.val > high) {
            root = trimBST(root.left, low, high);
        }
        return root;
    }
}