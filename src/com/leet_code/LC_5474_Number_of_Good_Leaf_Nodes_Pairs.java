package com.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.leet_code.models.TreeNode;

public class LC_5474_Number_of_Good_Leaf_Nodes_Pairs {
    public static void main(String[] args) {
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
        System.out.print(countPairs(n20, 2));
    }

    public static int countPairs(TreeNode root, int distance) {
        int count = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        List<TreeNode> leafNodes = new ArrayList<>();
        getLeafNodes(root, leafNodes);
        for(int i = 0; i < leafNodes.size(); i++) {
            for(int y = 0; y < leafNodes.size(); y++) {
                if(i == y) {
                    continue;
                }

                if(h.containsKey(leafNodes.get(i).val) && h.containsKey(leafNodes.get(y).val)) {
                    continue;
                }

                int i1 = distanceBetween2(root, leafNodes.get(i).val, leafNodes.get(y).val);
                h.put(leafNodes.get(i).val, leafNodes.get(y).val);
                h.put(leafNodes.get(y).val, leafNodes.get(i).val);
                if(i1 <= distance) {
                    count++;
                }
            }
        }
        return count;
    }

    static void getLeafNodes(TreeNode root, List<TreeNode> leafNodes) {
        // If node is null, return
        if (root == null) { return; }

        // If node is leaf node, print its data
        if (root.left == null && root.right == null) {
            leafNodes.add(root);
            return;
        }

        // If right child exists, check for leaf
        // recursively
        if (root.right != null) { getLeafNodes(root.right, leafNodes); }

        // If left child exists, check for leaf
        // recursively
        if (root.left != null) { getLeafNodes(root.left, leafNodes); }
    }

    static int distanceBetween2(TreeNode root, int a, int b)
    {
        if (root == null)
            return 0;

        // Both keys lie in left
        if (root.val > a && root.val > b)
            return distanceBetween2(root.left, a, b);

        // Both keys lie in right
        if (root.val < a && root.val < b) // same path
            return distanceBetween2(root.right, a, b);

        // Lie in opposite directions (Root is
        // LCA of two nodes)
        if (root.val >= a && root.val <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);

        return 0;
    }

    static int distanceFromRoot(TreeNode root, int x)
    {
        if (root.val == x)
            return 0;
        else if (root.val > x)
            return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }

}
