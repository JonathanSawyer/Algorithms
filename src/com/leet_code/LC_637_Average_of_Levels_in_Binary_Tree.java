package com.leet_code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.leet_code.models.TreeNode;

public class LC_637_Average_of_Levels_in_Binary_Tree {
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

        System.out.println(averageOfLevels(n5));

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        List<Double> res = new ArrayList<>();
        double sum = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int size = q.size(); size > 0; size--) {
                final TreeNode poll = q.removeFirst();
                sum += poll.val;
                if (poll.left != null) { q.offerLast(poll.left); }
                if (poll.right != null) { q.offerLast(poll.right); }

            }
            double depth = sum / s;
            sum = 0;
            res.add(depth);
        }
        return res;
    }
}
