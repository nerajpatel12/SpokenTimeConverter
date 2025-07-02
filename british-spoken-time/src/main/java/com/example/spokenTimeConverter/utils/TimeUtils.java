package com.example.spokenTimeConverter.utils;

public class TimeUtils {
    private static final String[] numbers = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };

    public static String numberToWords(int number) {
        if (number <= 20) {
            return numbers[number];
        } else if (number < 30) {
            return "twenty-" + numbers[number - 20];
        } else {
            return Integer.toString(number);
        }
    }

    public static String to12HourClock(int hour) {
        int h = hour % 12;
        return numbers[h == 0 ? 12 : h];
    }
}