package com.example.inicial1.controllers;

import com.example.inicial1.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")

public class StatsController {
    @Autowired
    private StatsService ss;

    @GetMapping("/stats")
    public ResponseEntity<?> getStatistics() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ss.getMutantStatistics());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
}
