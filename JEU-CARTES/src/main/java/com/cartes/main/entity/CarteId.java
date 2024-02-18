package com.cartes.main.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarteId implements Serializable{
	
	private static final long serialVersionUID = -4017327212733224077L;
	private String couleur;
    private String valeur;
}