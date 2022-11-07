package tn.elife.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.elife.spring.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {
	
}