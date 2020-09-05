package com.leet_code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC_716_Max_Stack {
//    public static void main(String[] args) {
//        MaxStack maxStack = new MaxStack();
//        maxStack.push(5);
//        maxStack.push(1);
//        maxStack.push(5);
//        maxStack.top();
//        maxStack.popMax();
//        maxStack.top();
//        maxStack.peekMax();
//        maxStack.pop();
//        maxStack.top();
//    }
//
//    static class MaxStack {
//
//        Stack<Integer> minStack = new Stack<>();
//        Stack<Integer> maxStack = new Stack<>();
//        int lastElement;
//        public MaxStack() {
//
//        }
//
//        public void push(int x) {
//            lastElement = x;
//            if(maxStack.isEmpty() && minStack.isEmpty()) {
//                maxStack.add(x);
//            }
//            else if(x >= maxStack.peek()) {
//                maxStack.add(x);
//            }else {
//                minStack.add(x);
//            }
//        }
//
//        public int pop() {
//            if(minStack.peek() == lastElement) {
//                return maxStack.pop();
//            }
//        }
//
//        public int top() {
//
//        }
//
//        public int peekMax() {
//
//        }
//
//        public int popMax() {
//
//        }
//    }
}


// min    max
//         1
//         2
//         2
//         3
//
//
