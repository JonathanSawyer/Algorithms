package com.neat_coder;

import java.util.List;

import com.neat_coder.models.TreeNode;

public class LC_94_Binary_Tree_Inorder_Traversal {
    public static void run() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);

        n1.right = n2;
        n2.left = n3;
    }


}
