package com.example.inicial1.services;

import com.example.inicial1.dto.DTOStatistics;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    @Autowired
    private PersonaRepository pr;

    public DTOStatistics getMutantStatistics() {
        List<Persona> personas = pr.findAll();
        int mutantCount = 0;
        int nonMutantCount = 0;

        for (Persona persona : personas) {
            if (persona.isMutant()) {
                mutantCount++;
            } else {
                nonMutantCount++;
            }
        }

        double ratio = nonMutantCount > 0 ? (double) mutantCount / nonMutantCount : mutantCount;

        return new DTOStatistics(mutantCount, nonMutantCount, ratio);
    }
}
