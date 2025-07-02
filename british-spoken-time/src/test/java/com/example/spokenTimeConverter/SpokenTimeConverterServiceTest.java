package com.example.spokenTimeConverter;

import com.example.spokenTimeConverter.service.SpokenTimeConverterService;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class SpokenTimeConverterServiceTest {

    private SpokenTimeConverterService converter = new SpokenTimeConverterService();

    @Test
    public void testKnownTimes() {
        assertEquals("midnight", converter.convert("00:00"));
        assertEquals("noon", converter.convert("12:00"));
        assertEquals("quarter to ten", converter.convert("09:45"));
        assertEquals("five past two", converter.convert("02:05"));
    }

    @Test
    public void testInvalidTime() {
        assertThrows(DateTimeParseException.class, () -> converter.convert("25:00"));
        assertThrows(IllegalArgumentException.class, () -> converter.convert("bad"));
    }
}