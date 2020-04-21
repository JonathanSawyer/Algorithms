package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LC_5389_Display_Table_of_Food_Orders_in_a_Restaurant {
    public static void run() {
        String[][] strings = {
                { "David", "3", "Ceviche" },
                { "Corina", "10", "Beef Burrito" },
                { "David", "3", "Fried Chicken" },
                { "Carla", "5", "Water" },
                { "Carla", "5", "Ceviche" },
                { "Rous", "3", "Ceviche" }
        };

        List<List<String>> input = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            input.add(Arrays.asList((strings[i])));
        }

        List<List<String>> lists = displayTable(input);
        for (List<String> s : lists) {
            for (String i : s) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        // Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order.
        // Table,Beef Burrito,Ceviche,Fried Chicken,Water

        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        SortedSet<String> headers = new TreeSet();

        //calculate frequency map
        HashMap<Integer, Hashtable<String, Integer>> rows = new HashMap<>();

        for (List<String> order : orders) {
            String meal = order.get(2);
            String table = order.get(1);
            if (!headers.contains(meal)) {
                headers.add(meal);
            }
            int tableNumber = Integer.valueOf(table);

            Hashtable<String, Integer> item = rows.get(tableNumber);
            if (item == null) {
                Hashtable<String, Integer> map = new Hashtable<>();
                map.put(meal, 1);
                rows.put(tableNumber, map);
            } else {
                rows.get(tableNumber).merge(meal, 1, Integer::sum);
            }
        }

        Object[] headerArray = headers.toArray();
        List<List<Integer>> tempResult = new ArrayList<>();
        rows.forEach((tableNo, value) -> {
            List<Integer> level = new ArrayList<>();
            level.add(Integer.valueOf(tableNo));
            for (int i = 0; i < headerArray.length; i++) {
                Integer orDefault = Integer.valueOf(value.getOrDefault(headerArray[i], 0));
                level.add(orDefault);
            }
            tempResult.add(level);
        });

        Collections.sort(tempResult, (o1, o2) -> {
            int i = 0;
            while (i < o1.size()) {
                int i1 = Integer.compare(o1.get(i), o2.get(i));
                if (i1 != 0) {
                    return i1;
                }
                i++;
            }
            return 0;
        });

        for (String head : headers) {
            header.add(head);
        }
        result.add(header);

        for (List<Integer> tempResultItem : tempResult) {
            List<String> line = new ArrayList<>();
            for (Integer i : tempResultItem) {
                line.add(String.valueOf(i));
            }
            result.add(line);
        }

        return result;
    }
}
