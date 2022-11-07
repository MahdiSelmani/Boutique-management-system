package tn.elife.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.services.OperateurService;

@RestController
@RequestMapping("operateur")
public class OperateurRestController {
	@Autowired
	OperateurService operateurService;
	@PutMapping("/assignoperateurtofacture/{idoperateur}/{idfacture}")
	public void assignOperateurToFacture(@PathVariable("idoperateur") Long idOperateur, @PathVariable("idfacture") long idFacture) {
		operateurService.assignOperateurToFacture(idOperateur, idFacture);
	}
	

}
