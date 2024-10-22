package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")

public class PersonaController {
    @Autowired
    protected PersonaService ps;

    @GetMapping("/stats")
    public ResponseEntity<?> getStatistics() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ps.getMutantStatistics());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("/mutant/")
    public ResponseEntity<?> save(@RequestBody Map<String, String[]> request) {
        try {
            String[] adn = request.get("adn");
            return ResponseEntity.status(HttpStatus.CREATED).body(ps.savePersona(adn));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error interno. Por favor intente más tarde.\"}");
        }
    }
}
