package tn.elife.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.elife.spring.entities.SecteurActivite;

@Repository
public interface SecteurActiviteRepository extends CrudRepository<SecteurActivite, Long> {
	
	
	
	/*@Query(value="UPDATE `secteur_activite_fournisseur` SET `secteurs_activite_id_secteur_activite`= ?2  WHERE `fournisseur_id_fournisseur` = ?1 ;", nativeQuery=true)
	@Modifying
	@Transactional
	void assignSecteurActiviteToFournisseur(Long idFournisseur , Long idSecteurActivite);*/

}
