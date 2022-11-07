package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.DetailFournisseur;
import tn.elife.spring.repository.DetailFournisseurRepository;

@Service
public class DetailFournisseurService implements IService<DetailFournisseur> {
	@Autowired
	DetailFournisseurRepository df;

	@Override
	public List<DetailFournisseur> retrieveAll() {
		return (List<DetailFournisseur>) df.findAll();
	}

	@Override
	public DetailFournisseur addItem(DetailFournisseur t) {
		return df.save(t);
	}

	@Override
	public void deleteItem(long id) {
		df.deleteById(id);

	}

	@Override
	public DetailFournisseur updateItem(DetailFournisseur t) {
		return df.save(t);
	}

	@Override
	public DetailFournisseur retrieveItem(long id) {
		Object n = df.findById(id);
		return (DetailFournisseur) n; 
	}

}
