package com.leet_code;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class LC_42_Trapping_Rain_Water {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            int right = height[i];
            while (!stack.isEmpty() && right > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) break;

                int left = height[stack.peek()];
                int minHeight = Math.min(left, right);
                int length = i - stack.peek() - 1;
                ans += length * (minHeight - bottom);
            }
            stack.push(i);
        }
        return ans;
    }
}
