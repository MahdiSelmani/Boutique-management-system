package tn.elife.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.entities.Fournisseur;
import tn.elife.spring.entities.SecteurActivite;
import tn.elife.spring.services.FournisseurService;
import tn.elife.spring.services.SecteurActiviteService;

@RestController
@RequestMapping("/secteuractivite")
public class SecteurActiviteRestController {
	@Autowired
	SecteurActiviteService sas;
	@Autowired
	FournisseurService fr;
	@Autowired
	SecteurActiviteService ss;
	
	@PutMapping(value="/assignsecteurtofournisseur/{idFournisseur}/{idSecteur}")
	public void asignSecteurActiviteToFournisseur(@PathVariable("idFournisseur" ) Long idFournisseur, @PathVariable("idSecteur") Long idSecteur) {
		Fournisseur f =  fr.retrieveItem(idFournisseur);
		SecteurActivite s = ss.retrieveItem(idSecteur);
		f.getSecteursActivite().add(s);
		fr.updateItem(f);
		
	}

}
