package com.leet_code;

import com.leet_code.models.TreeNode;

public class LC_938_Range_Sum_of_BST {
    static int res;
    public static void main(String[] args) {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);

        n2.left = n1;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;

        //     2
        //    / \
        //   1   4
        //      / \
        //     3   5
        System.out.println(rangeSumBST(n2, 3, 5));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        res = 0;
        helper(root, L, R);
        return res;
    }

    public static void helper(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        if (node.val >= L && node.val <= R) {
            res += node.val;
        }
        System.out.println(node.val);
        if(L < node.val)
            helper(node.left, L, R);
        if(node.val < R)
            helper(node.right, L, R);
    }
}
