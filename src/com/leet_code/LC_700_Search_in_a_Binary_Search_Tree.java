package com.leet_code;

import com.leet_code.models.TreeNode;

public class LC_700_Search_in_a_Binary_Search_Tree {

    public static void main(String[] args) {
//        20
//       /  \
//     10   30
//    /  \
//   5   15

        final TreeNode n20 = new TreeNode(20);
        final TreeNode n30 = new TreeNode(30);
        final TreeNode n10 = new TreeNode(10);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n15 = new TreeNode(15);
        n20.right = n30;
        n20.left = n10;
        n10.right = n15;
        n10.left = n5;
        TreeNode treeNode = searchBST(n20, 0);
    }


    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }

        TreeNode treeNode = searchBST(root.left, val);
        if(treeNode != null) {
            return treeNode;
        }
        treeNode = searchBST(root.right, val);
        if(treeNode != null) {
            return treeNode;
        }
        return null;
    }
}
