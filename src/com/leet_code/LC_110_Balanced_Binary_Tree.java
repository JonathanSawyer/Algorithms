package com.leet_code;

import com.leet_code.models.TreeNode;

public class LC_110_Balanced_Binary_Tree {

    public static void main(String[] args) {
//                 2
//                / \
//               1   4
//                  / \
//                 3   5
//                      \
//                       6

        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);


        n2.left = n1;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;

        System.out.print(isBalanced(n2));

    }

    public static boolean isBalanced(TreeNode root) {

    }

    private static class Pair{
        int d;
        boolean isBalanced;

        Pair(int d, boolean isBalanced) {
            this.d = d;
            this.isBalanced = isBalanced;
        }
    }

    public Pair dfs(TreeNode root) {
        if(root == null) {
            return new Pair(0, true);
        }
        final Pair left = dfs(root.left);
        final Pair right = dfs(root.right);
        final boolean balanced = left.isBalanced && right.isBalanced && Math.abs(left.d - right.d) <= 1;
        return new Pair(Math.max(left.d, right.d) + 1, balanced);
    }
}
