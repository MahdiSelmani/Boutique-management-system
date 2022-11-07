package tn.elife.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.entities.Facture;
import tn.elife.spring.entities.Reglement;
import tn.elife.spring.services.FactureService;

@RestController
@RequestMapping("/facture")
public class FactureRestController {

	@Autowired
	FactureService serviceFacture;

	@GetMapping("/{idFournisseur}")
	@ResponseBody
	public List<Facture> getFactureByFournisseur(@PathVariable("idFournisseur") Long idFournisseur) {
		return serviceFacture.getFactureByFournisseur(idFournisseur);
	}

	@GetMapping("/retrieve-all")
	@ResponseBody
	public List<Facture> getAllFactures() {
		return serviceFacture.retrieveAll();
	}

	@GetMapping("/facture/{idFacture}")
	@ResponseBody
	public List<Reglement> getREglementByFacture(@PathVariable("idFacture") Long idFacture) {
		return getREglementByFacture(idFacture);

	}
	
	

}
