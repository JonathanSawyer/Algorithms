package com.leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_346_Moving_Average_from_Data_Stream {
    public static class MovingAverage {

        Deque<Integer> queue = new ArrayDeque<Integer>();
        int _size;
        int sum = 0;

        public MovingAverage(int size) {
            _size = size;
        }

        public double next(int val) {
            if (queue.size() == _size) {
                int integer = queue.removeLast();
                sum -= integer;
            }
            sum += val;
            queue.addFirst(val);
            return (double) sum / queue.size();
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));      //= 1
        System.out.println(m.next(10));     // = (1 + 10) / 2
        System.out.println(m.next(3));      // = (1 + 10 + 3) / 3
        System.out.println(m.next(5));      //= (10 + 3 + 5) / 3
    }
}
//}[null,1.00000,5.50000,4.66667,6.00000]
