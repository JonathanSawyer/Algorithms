package com.neet_coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.neet_coder.models.TreeNode;

public class LC_297_Serialize_and_Deserialize_Binary_Tree {
    //             1
//                / \
//               2   3
//                  / \
//                 4   5
//            "[1,2,3,null,null,4,5]"
    public static void run() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;

        final String serialize = serialize(n1);
        final TreeNode deserialize = deserialize(serialize);
    }

    public static String rSerialize(TreeNode t, String result) {
        if (t == null) {
            result += "null,";
        } else {
            result += t.val + ",";
            result = rSerialize(t.left, result);
            result = rSerialize(t.right, result);
        }
        return result;
    }

    public static String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public static TreeNode rDeserialize(List<String> l) {
        if(l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = rDeserialize(l);
        node.right = rDeserialize(l);
        return node;
    }

    public static TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rDeserialize(data_list);
    }
}
