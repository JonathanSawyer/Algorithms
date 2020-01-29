package com.neat_coder;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class LC_155_Min_Stack {
    private Queue<Integer> priorityQueue = new PriorityQueue<>();
    private Stack<Integer> _stack = new Stack<>();

    public LC_155_Min_Stack() {

    }

    public void push(int x) {
        _stack.push(x);
        priorityQueue.add(x);
    }

    public Integer pop() {
        Integer integer = _stack.pop();
        priorityQueue.remove(integer);
        return integer;
    }

    public int top() {
        return _stack.peek();
    }

    public int getMin(){
        return priorityQueue.peek();
    }
}
