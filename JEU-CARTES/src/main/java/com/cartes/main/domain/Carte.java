package com.cartes.main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Carte {

	private final String valeur;
    private final String couleur;
    private String path;
	
    public String getNomCarte() {
    	return String.format("%s de %s", valeur, couleur);
    }
	
}
