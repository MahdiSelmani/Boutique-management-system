package tn.elife.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.CategorieProduit;

@Repository
public interface CategorieProduitRepository extends CrudRepository<CategorieProduit, Long> {
		
}
