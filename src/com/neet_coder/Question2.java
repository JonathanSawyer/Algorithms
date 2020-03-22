package com.neet_coder;

import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public static void run() {
        CustomStack c = new CustomStack(3);
        c.push(1);
        c.push(2);
        c.push(3);
    }

    public static class CustomStack {
        public int _maxStack = 0;
        public List<Integer> stack = new ArrayList<>();
        public CustomStack(int maxSize) {
            _maxStack =  maxSize;
        }

        public void push(int x) {
            if(_maxStack != stack.size()) {
                stack.add(x);
            }
        }

        public int pop() {
            if(stack.isEmpty()) {
                return -1;
            }
            Integer integer = stack.get(0);
            stack.remove(0);
            return integer;
        }

        public void increment(int k, int val) {
            if(stack.size() < k) {
                Integer integer = stack.get(k);
                stack.set(k, integer);
            }
        }
    }
}


