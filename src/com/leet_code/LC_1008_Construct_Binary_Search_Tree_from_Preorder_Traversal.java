package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.leet_code.models.TreeNode;

public class LC_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
    //  Input:  [8,5,1,7,10,12] preorder
//  Output: [8,5,10,1,7,null,12]
//     8
//    / \
//   5  10
//  / \  \
// 1  7  12
    public static void run() {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        List<Integer> preorderList = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i : preorder) { preorderList.add(i);}
        Arrays.sort(preorder);
        for (int i = preorderList.size() - 1; i >= 0; i--) {
            stack.add(preorderList.get(i));
        }

        TreeNode treeNode = generateSubtree(stack, Integer.MAX_VALUE);
    }

    static TreeNode generateSubtree(Deque<Integer> preorder, int maxVal) {
        if (preorder.isEmpty() || preorder.peekLast() > maxVal) {
            return null;
        }
        int currentVal = preorder.removeLast();
        TreeNode currentNode = new TreeNode(currentVal);
        currentNode.left = generateSubtree(preorder, currentVal);
        currentNode.right = generateSubtree(preorder, maxVal);
        return currentNode;
    }
}
