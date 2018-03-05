package com.codingchallenge.samlee.imdb.utils;

/**
 * Created by Sam on 3/4/2018.
 */

public class ConvertUtil {

    public static String convertMinutesToHrMin(String minutesString) {
        if (minutesString == null) {
            return null;
        }

        // minutesString is something like "140 min" so I used a .split to get the integer of minutes.
        String[] minsSplit = minutesString.split(" ");
        int minutes = Integer.parseInt(minsSplit[0]);
        int hours = minutes / 60;
        int mins = minutes % 60;

        return hours + "hr " + mins + "min";
    }
}
