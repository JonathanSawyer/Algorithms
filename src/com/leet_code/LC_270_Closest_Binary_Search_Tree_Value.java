package com.leet_code;

import com.leet_code.models.TreeNode;

public class LC_270_Closest_Binary_Search_Tree_Value {
    static double currentClosest;
    static int currentSmallest;
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
        System.out.println(closestValue(n5, 3.714286));
//         5
//        / \
//       3   6
//      / \
//     2   4
//    /
//   1

    }

    public static int closestValue(TreeNode root, double target) {
        currentClosest = 0x1.fffffffffffffP+1023;
        currentSmallest = 0;
        helper(root, target);
        return currentSmallest;
    }

    public static void helper(TreeNode root, double target) {
        if(root == null) {
            return;
        }
        double v = Math.abs(target - root.val);
        if(v < currentClosest) {
            currentClosest = v;
            currentSmallest = root.val;
        }
        helper(root.left, target);
        helper(root.right, target);
    }
}
