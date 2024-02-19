package com.cartes.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cartes.main.domain.JeuDeCartes;
import com.cartes.main.entity.CarteEntity;
import com.cartes.main.entity.CarteId;
import com.cartes.main.mapper.CarteMapper;
import com.cartes.main.repository.ICarteRepository;

public class CartesServiceTest {

    private ICarteRepository carteRepository;
    private CarteMapper carteMapper;
    private CartesService cartesService;

    @BeforeEach
    public void setUp() {
        carteRepository = mock(ICarteRepository.class);
        carteMapper = new CarteMapper();
        cartesService = new CartesService(carteRepository, carteMapper);
    }

    @Test
    public void testRecupererJeuDeCartesAleatoire() {
        CarteEntity carteEntity1 = new CarteEntity(new CarteId("As", "Coeur"));
        CarteEntity carteEntity2 = new CarteEntity(new CarteId("2", "Carreau"));
        List<CarteEntity> cartesEntities = Arrays.asList(carteEntity1, carteEntity2);

        when(carteRepository.findAll()).thenReturn(cartesEntities);

        JeuDeCartes jeuDeCartes = cartesService.recupererJeuDeCartesAleatoire();

        assertEquals(cartesEntities.size(), jeuDeCartes.getCartes().size());
        Mockito.verify(carteRepository, Mockito.times(1)).findAll();
    }
    
    
}

