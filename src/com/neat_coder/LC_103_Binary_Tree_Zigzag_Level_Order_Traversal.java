package com.neat_coder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.neat_coder.models.TreeNode;

public class LC_103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public static void run() {
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n9 = new TreeNode(9);
        final TreeNode n20 = new TreeNode(20);
        final TreeNode n15 = new TreeNode(15);
        final TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        zigzagLevelOrder(n3);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            TreeNode remove = q.remove();
            System.out.println(remove.val);
            if(remove.left != null) {
                q.add(remove.left);
            }
            if(remove.right != null) {
                q.add(remove.right);
            }
        }
        return null;
    }
}
