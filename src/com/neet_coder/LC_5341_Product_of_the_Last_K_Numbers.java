package com.neet_coder;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;


public class LC_5341_Product_of_the_Last_K_Numbers {
    public static void run() {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        int product = productOfNumbers.getProduct(
                2);// return 20. The product of the last 2 numbers is 5 * 4 = 20
        int product1 = productOfNumbers.getProduct(
                3);// return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        int product2 = productOfNumbers.getProduct(
                4);// return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        int product3 = productOfNumbers.getProduct(2);
    }

    public static class ProductOfNumbers {
        List<Integer> values = new ArrayList();
        public ProductOfNumbers() {

        }

        public void add(int num) {
            values.add(num);
        }

        public int getProduct(int k) {
            int start = values.size() - k;
            List<Integer> skipped = values.stream()
                                          .skip(start).collect(toList());
            int result = 1;
            for(int i : skipped) {
                result *= i;
            }
            return result;
        }
    }
}
