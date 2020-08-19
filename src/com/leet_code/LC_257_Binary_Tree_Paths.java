package com.leet_code;

import java.util.ArrayList;
import java.util.List;

import com.leet_code.models.TreeNode;

public class LC_257_Binary_Tree_Paths {
    public static void main(String[] args) {
//        2
//       / \
//     1   3
//    / \
//   5   4

        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n5 = new TreeNode(5);
        n2.left = n1;
        n1.left = n5;
        n1.right = n4;
        n2.right = n3;
        binaryTreePaths(n2).forEach(System.out::println);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        final String result = "";
        final List<String> res = new ArrayList<>();
        helper(root, res, result);
        return res;
    }

    public static void helper(TreeNode node, List<String> res, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            path += node.val;
            res.add(path);
            return;
        }

        path += node.val + "->";
        helper(node.left, res, path);
        helper(node.right, res, path);
    }
}
