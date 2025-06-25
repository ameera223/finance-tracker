package com.example.financetracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;


@RestController
public class HealthController {

//    @GetMapping("/api/health")
//    public String healthCheck() {
//        return "Finance Tracker API is up and running!";
//    }
@Value("${spring.application.name}")
private String appName;

    @GetMapping("/api/health")
    public Map<String, Object> healthCheck() {
        return Map.of(
                "status", "UP",
                "application", appName,
                "timestamp", LocalDateTime.now().toString()
        );
    }
}
