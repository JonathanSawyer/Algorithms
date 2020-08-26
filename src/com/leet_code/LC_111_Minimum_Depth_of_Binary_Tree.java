package com.leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.leet_code.models.TreeNode;

public class LC_111_Minimum_Depth_of_Binary_Tree {
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
        System.out.println(minDepth(n5));
    }

    public static int minDepth(TreeNode root) {
       return -1;
    }
}
