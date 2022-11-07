package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Reglement;
import tn.elife.spring.repository.ReglementRepository;

@Service
public class ReglementService implements IService<Reglement> {
	@Autowired
	ReglementRepository rr;

	@Override
	public List<Reglement> retrieveAll() {
		return (List<Reglement>) rr.findAll();
	}

	@Override
	public Reglement addItem(Reglement t) {
		return rr.save(t);
	}

	@Override
	public void deleteItem(long id) {
		rr.deleteById(id);

	}

	@Override
	public Reglement updateItem(Reglement t) {
		return rr.save(t);
	}

	@Override
	public Reglement retrieveItem(long id) {
		Object n = rr.findById(id);
		return (Reglement) n;
	}

}
