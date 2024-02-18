package com.cartes.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cartes.main.domain.Carte;
import com.cartes.main.domain.JeuDeCartes;
import com.cartes.main.service.CartesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartesController {

	@Autowired
	private CartesService carteService;
	
	
	@GetMapping("/check")
    public ResponseEntity<String> getStatusMessage() {
        return new ResponseEntity<>("L'application est en cours d'execution", HttpStatus.OK);
    }

	@GetMapping("/init")
	public ResponseEntity<String> init() {

		log.info("Initialisation de l'application");
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		jeuDeCartes.init();
		carteService.sauvegarderJeuDeCartes(jeuDeCartes);
		JeuDeCartes res = carteService.recupererJeuDeCartesAleatoire();

		log.info("Jeu lu en BDD");
		res.getCartes().forEach(carte -> {
			log.info(carte.getNomCarte());
		});

		return new ResponseEntity<String>("Initialisation terminée", HttpStatus.OK);
	}

	@GetMapping("/cartes")
    public String afficherCartes(Model model) {
		log.info("Debut de la lecture des cartes en base de données");
        List<Carte> cartes = carteService.recupererJeuDeCartesAleatoire().getCartes();
        model.addAttribute("cartes", cartes);
        return "afficherCartes"; 
    }

}
