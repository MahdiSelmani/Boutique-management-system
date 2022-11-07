package tn.elife.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

}
