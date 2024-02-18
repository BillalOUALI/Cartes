package com.cartes.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartes.main.entity.CarteEntity;
import com.cartes.main.entity.CarteId;

@Repository
public interface ICarteRepository extends JpaRepository<CarteEntity, CarteId> {

}
