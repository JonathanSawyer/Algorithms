package com.neet_coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_5370_Design_Underground_System {

    public static void run() {
        final UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        double averageTime = undergroundSystem.getAverageTime("Paradise",
                                                              "Cambridge");// return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        double averageTime1 = undergroundSystem.getAverageTime("Leyton",
                                                               "Waterloo");// return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        double averageTime2 = undergroundSystem.getAverageTime("Leyton", "Waterloo");// return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        double averageTime3 = undergroundSystem.getAverageTime("Leyton", "Waterloo");
    }



    static class UndergroundSystem {
        static class Pair<T, K> {
            public Pair() {}

            public Pair(T key, K value) {
                this.key = key;
                this.value = value;
            }

            public T key;
            public K value;

        }

        // id <station, time>
        // If we encounter another item during the trip we know the user already checked in
        // When we get a checkout we clear the users records and update our average
        public HashMap<Integer, Queue<Pair<String, Integer>>> customerJourney = new HashMap<>();
        // start-endstation
        public HashMap<String, List<Integer>> averageTime = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            Queue<Pair<String, Integer>> stringIntegerTreeMap;
            if (customerJourney.containsKey(id)) {
                stringIntegerTreeMap = customerJourney.get(id);
            } else {
                stringIntegerTreeMap = new LinkedList<>();
            }
            stringIntegerTreeMap.add(new Pair<>(stationName, t));
            customerJourney.put(id, stringIntegerTreeMap);
        }

        public void checkOut(int id, String stationName, int t) {
            final Queue<Pair<String, Integer>> pairs = customerJourney.get(id);
            final Pair<String, Integer> stationToTime = pairs.poll();
            customerJourney.remove(id);

            final String[] stationKey = { stationName, stationToTime.key };
            Arrays.sort(stationKey);
            final String stationToStationKey = String.join("-", stationKey);
            List<Integer> time = averageTime.getOrDefault(stationToStationKey, new ArrayList<>());
            // need to deal with 23 start and 2 end scenario
            final int journeyTime = t - stationToTime.value;
            time.add(journeyTime);
            averageTime.put(stationToStationKey, time);
        }

        public double getAverageTime(String startStation, String endStation) {
            final String[] stationKey = { startStation, endStation };
            Arrays.sort(stationKey);
            final String stationToStationKey = String.join("-", stationKey);
            List<Integer> array = averageTime.get(stationToStationKey);
            int sum = 0;
            for (int value : array) {
                sum += value;
            }
            return (double) sum / array.size();
        }
    }

}


