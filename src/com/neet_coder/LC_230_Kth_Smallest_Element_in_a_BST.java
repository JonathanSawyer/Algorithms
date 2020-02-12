package com.neet_coder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.neet_coder.models.TreeNode;

public class LC_230_Kth_Smallest_Element_in_a_BST {
    public static void run() {
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
        int i = kthSmallest(n5, 2);
//         5
//        / \
//       3   6
//      / \
//     2   4
//    /
//   1
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            k--;
            if(k == 0) {
                return currentNode.val;
            }

            currentNode = currentNode.right;
        }
        //return res;
        return -1;
    }
}
