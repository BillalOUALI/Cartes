package com.cartes.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartes.main.domain.JeuDeCartes;
import com.cartes.main.entity.CarteEntity;
import com.cartes.main.mapper.CarteMapper;
import com.cartes.main.repository.ICarteRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CartesService {

	@Autowired
	private ICarteRepository repo;
	@Autowired
	private CarteMapper mapper;
	
	public void sauvegarderJeuDeCartes(JeuDeCartes jeuDeCartes) {
		log.info("Enregistrement des cartes");
		jeuDeCartes.getCartes().forEach(carte -> {repo.save(mapper.toEntity(carte));});
	}
	
	public JeuDeCartes recupererJeuDeCartesAleatoire() {
		JeuDeCartes jeuDeCarte = new JeuDeCartes();
		List<CarteEntity> cartes = new ArrayList<CarteEntity>();
		repo.findAll().forEach(cartes::add);
		cartes.forEach(carte -> {jeuDeCarte.ajouterCarte(mapper.toDomain(carte));});
		if(jeuDeCarte.getCartes() != null) {
			Collections.shuffle(jeuDeCarte.getCartes());			
		}
		return jeuDeCarte;
	}
	
}
