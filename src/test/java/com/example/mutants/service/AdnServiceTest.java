package com.example.mutants.service;
import com.example.inicial1.services.PersonaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdnServiceTest {
    // ====================================================================================================
    // Tests cubriendo todas las secuencias de matriz 6x6
    @Test
    public void testRows() {
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testColumns() {
        String[] dna = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTC",
                "GTAGTC",
                "GGTCAC"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testMainDiagonals() {
        String[] dna = {
                "AGAATG",
                "TACAGT",
                "GCAGCC",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testSecondaryLeftDiagonals() {
        String[] dna = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testSecondaryRightDiagonals() {
        String[] dna = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testTertiaryLeftDiagonals() {
        String[] dna = {
                "ATGATG",
                "GTAGTA",
                "CCTTGG",
                "TCTAGG",
                "GGCGTC",
                "AGTCAA"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testTertiaryRightDiagonals() {
        String[] dna = {
                "ATGATG",
                "GTATTA",
                "AATTGG",
                "ACTAGT",
                "GGAGTC",
                "AGGCAA"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testNonMutant() {
        String[] dna = {
                "ATGATG",
                "GTCTTA",
                "AATTGG",
                "ACTAGT",
                "GGATTC",
                "AGGCAA"
        };
        assertFalse(PersonaService.isMutant(dna));
    }


    // ====================================================================================================
    // Tests brindados por el profesor
    @Test
    public void testMutant1() {
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testNonMutant1() {
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(PersonaService.isMutant(dna));
    }

    @Test
    public void testMutant2() {
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testMutant3() {
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertFalse(PersonaService.isMutant(dna));
    }

    @Test
    public void testNonMutant2() {
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        assertFalse(PersonaService.isMutant(dna));
    }

    @Test
    public void testMutant4() {
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        assertTrue(PersonaService.isMutant(dna));
    }

    @Test
    public void testMutant5() {
        String[] dna = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };
        assertTrue(PersonaService.isMutant(dna));
    }
}
