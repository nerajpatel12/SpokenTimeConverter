package com.example.spokenTimeConverter.controller;

import com.example.spokenTimeConverter.service.SpokenTimeConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    private final SpokenTimeConverterService converter;

    public TimeController(SpokenTimeConverterService converter){
        this.converter = converter;
    }

    @GetMapping("/spoken")
    public ResponseEntity<String> getSpokenTime(@RequestParam String time) {
        try {
            return ResponseEntity.ok(converter.convert(time));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid time format: " + ex.getMessage());
        }
    }
}