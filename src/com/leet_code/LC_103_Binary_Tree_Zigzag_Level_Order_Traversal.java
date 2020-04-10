package com.leet_code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.leet_code.models.TreeNode;

public class LC_103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public static void run() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        List<List<Integer>> lists = zigzagLevelOrder(n1);

//          1
//         / \
//        2  3
//      /  \
//     4    5

//  [
//  [3],
//  [20,9],
//  [15,7]
//  ]
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offerFirst(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            final LinkedList<Integer> level = new LinkedList<>();
            //for(int i=queue.size(); i>=0; i--) {
            while (levelSize-- > 0) {
                final TreeNode curr = queue.removeLast();
                if (res.size() % 2 == 0) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }
                if (curr.left != null) {
                    queue.offerFirst(curr.left);
                }
                if (curr.right != null) {
                    queue.offerFirst(curr.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
