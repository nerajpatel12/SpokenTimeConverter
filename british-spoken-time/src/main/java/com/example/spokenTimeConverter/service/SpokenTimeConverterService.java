package com.example.spokenTimeConverter.service;

import com.example.spokenTimeConverter.utils.TimeUtils;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SpokenTimeConverterService {

    public String convert(String time) {
        if (time == null || !time.matches("^\\d{2}:\\d{2}$")) {
            throw new IllegalArgumentException("Time must be in HH:mm format");
        }

        LocalTime localTime = LocalTime.parse(time);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        String hourText = TimeUtils.to12HourClock(hour);
        String nextHourText = TimeUtils.to12HourClock((hour + 1) % 24);

        if (minute == 0) return hourText + " o'clock";
        if (minute == 15) return "quarter past " + hourText;
        if (minute == 30) return "half past " + hourText;
        if (minute == 45) return "quarter to " + nextHourText;
        if (minute < 30) return TimeUtils.numberToWords(minute) + " past " + hourText;
        if (minute > 30) return TimeUtils.numberToWords(60 - minute) + " to " + nextHourText;

        return hourText + " " + String.format("%02d", minute);
    }
}