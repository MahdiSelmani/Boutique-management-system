package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Fournisseur;
import tn.elife.spring.entities.SecteurActivite;
import tn.elife.spring.repository.FournisseurRepository;
import tn.elife.spring.repository.SecteurActiviteRepository;
@Service
public class SecteurActiviteService implements IService<SecteurActivite> {
	@Autowired
	SecteurActiviteRepository sar;
	

	@Override
	public List<SecteurActivite> retrieveAll() {
		return (List<SecteurActivite>) sar.findAll();
		
	}

	@Override
	public SecteurActivite addItem(SecteurActivite t) {
		return sar.save(t);
	}

	@Override
	public void deleteItem(long id) {
		sar.deleteById(id);
		
	}

	@Override
	public SecteurActivite updateItem(SecteurActivite t) {
		return sar.save(t);
	}

	@Override
	public SecteurActivite retrieveItem(long id) {
		return sar.findById(id).get();
	}
	
	
	

}
