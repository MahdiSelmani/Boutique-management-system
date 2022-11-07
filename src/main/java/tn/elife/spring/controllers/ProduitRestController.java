package tn.elife.spring.controllers;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.elife.spring.entities.Produit;
import tn.elife.spring.services.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitRestController {
	@Autowired
	ProduitService produitService;
	

	//@PutMapping(value="/assignproduittostock/{idProduit}/{idStock}")
	//public void assignProduitToStock(@PathVariable("idProduit" ) Long idProduit, @PathVariable("idStock") Long idStock) {
	//	produitService.assignProduitToStock(idProduit, idStock);

	//}

	
	@RequestMapping(method = RequestMethod.PUT,value="/assignproduittostock", consumes= MediaType.APPLICATION_JSON_VALUE)
	public void assignProduitToStock(@RequestBody Long idProduit, @RequestBody Long idStock) {
		
		produitService.assignProduitToStock(idProduit, idStock);

	}
	
	
	
	
	
	@GetMapping("/retrieve-all")
	@ResponseBody
	public List<Produit> getFournisseurs() {
		return produitService.retrieveAll();

	}

	@GetMapping("/{id}")
	@ResponseBody
	public Object getProduit(@PathVariable("id") Long id) {
		return produitService.retrieveItem(id);

	}

	@PostMapping("/add")
	@ResponseBody
	public String addProduit(@RequestBody Produit p) {
		produitService.addItem(p);
		return "Ajouté avec succés";

	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteProduit(@PathVariable("id") Long id) {

		try {
			produitService.deleteItem(id);
			return "Supprimé avec succés";

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@PutMapping("/update")
	@ResponseBody
	public String updateProduit(@RequestBody Produit f) {
		if (produitService.updateItem(f) != null)
			return "mis à jour avec succés";
		return "Produit n'est pas existant";
	}

}
