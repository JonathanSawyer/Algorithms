package com.neet_coder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class comp_2 {
    public static void run() {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3",
                                10);                             // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
        //List<Integer> tweetCountsPerFrequency = tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0,
        //         59);// return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
        List<Integer> tweetCountsPerFrequency1 = tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0,
                                                                                        60);// return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
        tweetCounts.recordTweet("tweet3",
                                120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
        List<Integer> tweetCountsPerFrequency2 = tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0,
                                                                                        210);// return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.
    }

    public static class TweetTime {
        public TweetTime(String name, int time) {
            this.name = name;
            this.time = time;

        }

        public String name;
        public int time;

        public String getName() {
            return this.name;
        }

        public int getTime() {
            return this.time;
        }
    }

    public static class TweetCounts {

        public static List<TweetTime> tweets = new ArrayList<>();

        public TweetCounts() {
        }

        public void recordTweet(String tweetName, int time) {
            tweets.add(new TweetTime(tweetName, time));
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime,
                                                        int endTime) {
            int minute = 60;
            int hour = 3600;
            int day = 86400;

            List<Integer> intervalResul = new ArrayList<>();

            int finalStartTime = startTime;
            final List<TweetTime> byTweetName = tweets.stream()
                                                      .filter(tweetTime -> {
                                                          return tweetTime.getName() == tweetName
                                                                 && tweetTime.getTime() >= finalStartTime
                                                                 && tweetTime.getTime() <= endTime;
                                                      })
                                                      .sorted(Comparator.comparingInt(TweetTime::getTime))
                                                      .collect(Collectors.toList());

            int totalInterval = endTime - startTime;
            if (freq.equals("minute")) {
                for (int i = startTime; startTime < endTime; startTime += minute) {
                    int finalStartTime1 = startTime;
                    int finalEndTime = startTime + minute;
                    int count = (int) byTweetName.stream().filter(tweetTime -> {
                        return tweetTime.getTime() >= finalStartTime1 && tweetTime.getTime() < finalEndTime;
                    }).count();
                    intervalResul.add(count);
                }
            }

            endTime

            return intervalResul;
        }
    }
}
