package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.CategorieProduit;
import tn.elife.spring.repository.CategorieProduitRepository;

@Service
public class CategorieProduitService implements IService<CategorieProduit> {
	@Autowired
	CategorieProduitRepository cps;
	@Override
	public List<CategorieProduit> retrieveAll() {
		return (List<CategorieProduit>) cps.findAll();
	}

	@Override
	public CategorieProduit addItem(CategorieProduit t) {
		
		return cps.save(t);
	}

	@Override
	public void deleteItem(long id) {
		cps.deleteById(id);
		
	}

	@Override
	public CategorieProduit updateItem(CategorieProduit t) {
		return cps.save(t);
	}

	@Override
	public CategorieProduit retrieveItem(long id) {
		Object n = cps.findById(id);
		return (CategorieProduit) n;
	}

}
