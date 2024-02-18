package com.cartes.main.mapper;

import org.springframework.stereotype.Component;

import com.cartes.main.domain.Carte;
import com.cartes.main.entity.CarteEntity;
import com.cartes.main.entity.CarteId;

@Component
public class CarteMapper {

	public CarteEntity toEntity(Carte carte) {
		return new CarteEntity(new CarteId(carte.getCouleur(), carte.getValeur()));
	}
	
	public Carte toDomain(CarteEntity carteEntity) {
		Carte carte = new Carte(carteEntity.getId().getCouleur(), carteEntity.getId().getValeur());
		carte.setPath(String.format("/images/cartes/%s - %s.png", carte.getValeur(), carte.getCouleur()));
		return carte;
	}
	
}
