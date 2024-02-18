package com.cartes.main.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JeuDeCartes {

	private List<Carte> cartes;
	
	public void init() {
		log.info("initialisation de la création du jeu de cartes");
		String[] couleurs = {"Coeur", "Carreau", "Trèfle", "Pique"};
        String[] valeurs = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"};
        cartes = new ArrayList<>();
        for (String couleur : couleurs) {
            for (String valeur : valeurs) {
                Carte carte = new Carte(couleur, valeur);
                cartes.add(carte);
                log.info(String.format("Carte ajoutée: %s", carte.getNomCarte()));
            }
        }
	}
	
	public void ajouterCarte(Carte carte) {
		if(cartes == null) {
			cartes = new ArrayList<Carte>();
			cartes.add(carte);
		}else {
			cartes.add(carte);
		}
	}
}
