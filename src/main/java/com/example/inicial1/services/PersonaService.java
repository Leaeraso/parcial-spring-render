package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.dto.DTOStatistics;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository pr;

    private static final int SEQUENCE_LENGTH = 4;
    private static final int REQUIRED_MUTANT_SEQUENCES = 2;
    private static char lastValueSequence = '\0';

    public Persona savePersona(String[] adn) {
        //Validar que no sea un array vacio
        if (adn == null || adn.length == 0) {
            throw new IllegalArgumentException("El array de ADN no puede ser nulo o vacío.");
        }

        int n = adn.length;
        for (String adnLine : adn) {
            //Validar que no reciba null
            if (adnLine == null) {
                throw new IllegalArgumentException("El array de ADN no puede contener valores nulos.");
            }
            //Validar que el array sea de NxN
            if (adnLine.length() != n) {
                throw new IllegalArgumentException("El array de ADN debe ser de NxN.");
            }
            //Validar que no reciba letras distintas o numeros
            if (!adnLine.matches("[ATCG]+")) {
                throw new IllegalArgumentException("El array de ADN contiene caracteres inválidos.");
            }
        }

        boolean isMutant = isMutant(adn);

        Persona persona = new Persona();
        persona.setAdn(adn);
        persona.setMutant(isMutant);
        return pr.save(persona);

    }

    public static boolean isMutant(String[] adn) {
        int n = adn.length;
        int mutantSequences = 0;

        // Algoritmo de reconocimiento
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Secuencia horizontal
                if (j <= n - SEQUENCE_LENGTH && checkSequence(adn, i, j, 0, 1)) {
                    mutantSequences++;
                    if (mutantSequences >= REQUIRED_MUTANT_SEQUENCES) return true;
                }
                // Secuencia vertical
                if (i <= n - SEQUENCE_LENGTH && checkSequence(adn, i, j, 1, 0)) {
                    mutantSequences++;
                    if (mutantSequences >= REQUIRED_MUTANT_SEQUENCES) return true;
                }
                // Secuencia diagonal derecha
                if (i <= n - SEQUENCE_LENGTH && j <= n - SEQUENCE_LENGTH && checkSequence(adn, i, j, 1, 1)) {
                    mutantSequences++;
                    if (mutantSequences >= REQUIRED_MUTANT_SEQUENCES) return true;
                }
                // Secuencia diagonal izquierda
                if (i <= n - SEQUENCE_LENGTH && j >= SEQUENCE_LENGTH - 1 && checkSequence(adn, i, j, 1, -1)) {
                    mutantSequences++;
                    if (mutantSequences >= REQUIRED_MUTANT_SEQUENCES) return true;
                }
            }
        }

        return false;
    }

    // Metodo Auxiliar
    private static boolean checkSequence(String[] adn, int i, int j, int deltaI, int deltaJ) {
        char firstChar = adn[i].charAt(j);

        for (int k = 1; k < SEQUENCE_LENGTH; k++) {
            if (adn[i + k * deltaI].charAt(j + k * deltaJ) != firstChar) {
                return false;
            }
        }
        if(firstChar == lastValueSequence) {
            return false;
        }
        lastValueSequence = firstChar;
        return true;
    }

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
