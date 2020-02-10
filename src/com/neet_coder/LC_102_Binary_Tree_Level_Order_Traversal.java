package com.neet_coder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.neet_coder.models.TreeNode;

public class LC_102_Binary_Tree_Level_Order_Traversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {return new ArrayList<>();}

        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int counter = 1, newCounter = 0;
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (counter > 0) {
                final TreeNode poll = q.poll();
                if (poll.left != null) {
                    newCounter++;
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    newCounter++;
                    q.add(poll.right);
                }
                counter--;
                level.add(poll.val);
            }
            results.add(level);
            counter = newCounter;
            newCounter = 0;
        }
        return results;
    }

    public static void run() {

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

        levelOrder(n20);
    }
}
