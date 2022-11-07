package tn.elife.spring.controllers;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.entities.Fournisseur;
import tn.elife.spring.services.FournisseurService;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurRestController {
	@Autowired
	FournisseurService fournisseurService;

	@GetMapping("/retrieve-all")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
		return fournisseurService.retrieveAll();

	}

	@GetMapping("/{id}")
	@ResponseBody
	public Object getFournisseur(@PathVariable("id") Long id) {
		return fournisseurService.retrieveItem(id);

	}

	@PostMapping("/add")
	@ResponseBody
	public String addFournisseur(@RequestBody Fournisseur f) {
		fournisseurService.addItem(f);
		return "Ajouté avec succés";

	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteFournisseur(@PathVariable("id") Long id) {

		try {
			fournisseurService.deleteItem(id);
			return "Supprimé avec succés";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@PutMapping("/update")
	@ResponseBody
	public String updateFournisseur(@RequestBody Fournisseur f) {
		if (fournisseurService.updateItem(f) != null)
			return "mis à jour avec succés";
		return "Fournisseur n'est pas existant";
	}

}
