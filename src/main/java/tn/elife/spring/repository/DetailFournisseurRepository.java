package tn.elife.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.DetailFournisseur;

@Repository
public interface DetailFournisseurRepository extends CrudRepository<DetailFournisseur, Long> {

}
