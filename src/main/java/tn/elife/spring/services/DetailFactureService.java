package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.DetailFacture;
import tn.elife.spring.repository.DetailFactureRepository;

@Service
public class DetailFactureService implements IService<DetailFacture> {
	@Autowired
	DetailFactureRepository dfr;
	@Override
	public List<DetailFacture> retrieveAll() {
		return (List<DetailFacture>) dfr.findAll();
	}

	@Override
	public DetailFacture addItem(DetailFacture t) {
		return dfr.save(t);
	}

	@Override
	public void deleteItem(long id) {
		dfr.deleteById(id);
	}

	@Override
	public DetailFacture updateItem(DetailFacture t) {
		return dfr.save(t);
	}

	@Override
	public DetailFacture retrieveItem(long id) {
		Object n = dfr.findById(id);
		return (DetailFacture) n;
	}

}
