package com.leet_code;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LC_380_Insert_Delete_GetRandom_O_1 {
    public static void run() {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(1);
        boolean param_3 = obj.insert(2);
        boolean param_4 = obj.remove(2);
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
            locs.put(val, nums.size());
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

            locs.put(lastElement, itemIndexToRemove);
            nums.set(itemIndexToRemove, lastElement);

            out.println("locs.put(" + lastElement + ' ' + itemIndexToRemove);
            out.println("nums.set(" + itemIndexToRemove + ' ' + lastElement);

            locs.remove(val);
            nums.remove(nums.size() -1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}

