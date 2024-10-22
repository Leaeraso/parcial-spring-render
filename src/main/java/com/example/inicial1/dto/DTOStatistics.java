package com.example.inicial1.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DTOStatistics {
    private int mutantCount;
    private int nonMutantCount;
    private double ratio;
}