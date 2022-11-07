package tn.elife.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.DetailFacture;

@Repository
public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long> {

}
