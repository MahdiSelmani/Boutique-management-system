package tn.elife.spring.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.elife.spring.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
	
	//@Query(value ="UPDATE produit set produit.stock_id_stock = ?2 where produit.id_produit = ?1", nativeQuery = true)
	//@Modifying
	//@Transactional
	//void assignProduitToStock(Long idProduit, Long idStock);
	

}
