package com.leet_code;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC_380_Insert_Delete_GetRandom_O_1 {
    public static void run() {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(1);
        obj.insert(2);
        obj.remove(1);
        obj.debug();
        obj.insert(2);
//        out.println(obj.getRandom());
    }
    public static class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> locs;
        Random rand = new Random();

        public RandomizedSet() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (locs.containsKey(val)) {
                return false;
            }
            nums.add(val);
            locs.put(val, nums.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!locs.containsKey(val)) {
                return false;
            }
            //TODO: last element case

            // we get the last element so that we can swap it
            // with the element we will remove from the
            // nums array.
            //
            // We will then update the last element in the dictionary
            // with its new position
            final int lastElement = nums.size() - 1;
            final Integer itemIndexToRemove = locs.get(val);

            locs.put(nums.get(lastElement), itemIndexToRemove);
            nums.set(itemIndexToRemove, nums.get(lastElement));
            locs.remove(val);
            nums.remove(nums.size() -1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }

        public void debug() {
            out.println("-----");
            for(int i: nums) {
                out.print(i + " ");
            }
            out.println();

            for(Entry e : locs.entrySet()) {
                out.println(e.getKey() + ":" + e.getValue());
            }
            out.println("-----");
        }
    }
}

