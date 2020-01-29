package com.neat_coder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LC_5320_Filter_Restaurants_by_Vegan_Friendly_Price_and_Distance {
    public static void run() {
        int[][] restaurants = new int[5][5];
        //1,4,1,40,10
        restaurants[0][0] = 1;
        restaurants[0][1] = 200;
        restaurants[0][2] = 0;
        restaurants[0][3] = 40;
        restaurants[0][4] = 10;

        //2,8,0,50,5
        restaurants[1][0] = 2;
        restaurants[1][1] = 20;
        restaurants[1][2] = 0;
        restaurants[1][3] = 50;
        restaurants[1][4] = 5;

        //3,8,1,30,4
        restaurants[2][0] = 3;
        restaurants[2][1] = 2;
        restaurants[2][2] = 1;
        restaurants[2][3] = 30;
        restaurants[2][4] = 4;

        //4,10,0,10,3
        restaurants[3][0] = 4;
        restaurants[3][1] = 20;
        restaurants[3][2] = 0;
        restaurants[3][3] = 10;
        restaurants[3][4] = 3;

        //5,1,1,15,1
        restaurants[4][0] = 5;
        restaurants[4][1] = 20;
        restaurants[4][2] = 1;
        restaurants[4][3] = 15;
        restaurants[4][4] = 1;

//        restaurants[4][1] = 10;
//        restaurants[4][2] = 5;
//        restaurants[4][3] = 4;
//        restaurants[4][4] = 3;
//        restaurants[4][5] = 1;

        List<Integer> integers = filterRestaurants(restaurants, 0, 50, 10);
    }

    public static class Restaurant {
        public int id;
        public int rating;
        public int vegan;
        public Integer price;
        public int distance;
        public Integer getRating() {
            return this.rating;
        }
        public Integer getId() {
            return this.distance;
        }
    }

    private static final int ID = 0;
    private static final int RANK = 1;
    private static final int VEGAN = 2;
    private static final int PRICE = 3;
    private static final int DISTANCE = 4;

    public List<Integer> filterRestaurants2(int[][] restaurants, int vegan, int maxPrice, int maxDistance) {


        final List<List<Integer>> list = new ArrayList<>();
        for (int[] r : restaurants) {
            final List<Integer> restaurant = new ArrayList<>();
            for (int i : r) { restaurant.add(i); }
            list.add(restaurant);
        }
        final Comparator<List<Integer>> byRankAndId = (r1, r2) -> {
            if (r1.get(RANK).equals(r2.get(RANK))) {
                return Integer.compare(r2.get(ID), r1.get(ID));
            }
            return Integer.compare(r2.get(RANK), r1.get(RANK));
        };
        return list.stream()
                   .filter(r -> vegan == 0 ? true : r.get(VEGAN) == 1)
                   .filter(r -> r.get(PRICE) <= maxPrice)
                   .filter(r -> r.get(DISTANCE) <= maxDistance)
                   .sorted(byRankAndId)
                   .map(r -> r.get(ID))
                   .collect(Collectors.toList());
    }

    public static List<Integer> filterRestaurants(int[][] restaurants,
                                                  int veganFriendly,
                                                  int maxPrice,
                                                  int maxDistance) {
        List<Restaurant> restaurantArrayList = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            final int[] restaurant1 = restaurants[i];
            final Restaurant restaurant = new Restaurant();
            restaurant.id = restaurant1[0];
            restaurant.rating = restaurant1[1];
            restaurant.vegan = restaurant1[2];
            restaurant.price = restaurant1[3];
            restaurant.distance = restaurant1[4];
            restaurantArrayList.add(restaurant);
        }

        restaurantArrayList = restaurantArrayList
                .stream()
                .filter(restaurant ->
                                (veganFriendly == 0 ? true : restaurant.vegan == 1)
                                && restaurant.price <= maxPrice
                                && restaurant.distance <= maxDistance)
                .sorted((o1, o2) -> {
                    if (o1.rating == o2.rating) {
                        return Integer.compare(o2.id, o1.id);
                    }
                    return Integer.compare(o2.rating, o1.rating);
                })
                .collect(Collectors.toList());

        Collections.sort(restaurantArrayList,
                         Comparator.comparingInt(Restaurant::getRating).reversed()
                                   .thenComparingInt(Restaurant::getId).reversed()
        );
        return restaurantArrayList.stream()
                                  .map(restaurant -> restaurant.id)
                                  .collect(Collectors.toList());
    }
}
