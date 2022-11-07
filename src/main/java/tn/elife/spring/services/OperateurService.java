package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Facture;
import tn.elife.spring.entities.Operateur;
import tn.elife.spring.repository.OperateurRepository;

@Service
public class OperateurService implements IService<Operateur> {
	@Autowired
	OperateurRepository or;
	@Autowired 
	FactureService fs;

	@Override
	public List<Operateur> retrieveAll() {
		return (List<Operateur>) or.findAll();
	}

	@Override
	public Operateur addItem(Operateur t) {
		return or.save(t);
	}

	@Override
	public void deleteItem(long id) {
		or.deleteById(id);

	}

	@Override
	public Operateur updateItem(Operateur t) {
		return or.save(t);
	}

	@Override
	public Operateur retrieveItem(long id) {
		return or.findById(id).get();
	}
	
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		Operateur operateur = retrieveItem(idOperateur) ;
		Facture facture = fs.retrieveItem(idFacture);
		operateur.getFactures().add(facture);
		updateItem(operateur);
		
	}

}
