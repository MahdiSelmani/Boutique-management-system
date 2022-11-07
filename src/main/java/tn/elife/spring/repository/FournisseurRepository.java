package tn.elife.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.Fournisseur;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {

}
