package com.leet_code;

import java.util.Stack;

import com.leet_code.models.TreeNode;

public class LC_173_Binary_Search_Tree_Iterator {
    public static void main(String[] args) {
//                 2
//                / \
//               1   4
//                  / \
//                 3   5

        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);

        n2.left = n1;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;

        BSTIterator bstIterator = new BSTIterator(n2);
        while(bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }

    static class BSTIterator {
        private Stack<TreeNode> leftMostNodes = new Stack<>();

        public BSTIterator(TreeNode root) {
            populateLeftMost(root);
        }

        public void populateLeftMost(TreeNode root) {
            while(root != null) {
                leftMostNodes.add(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode pop = leftMostNodes.pop();
            populateLeftMost(pop.right);
            return pop.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !leftMostNodes.isEmpty();
        }
    }
}
