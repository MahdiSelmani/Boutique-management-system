package tn.elife.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.elife.spring.entities.Fournisseur;
import tn.elife.spring.repository.FournisseurRepository;

@Service
public class FournisseurService implements IService<Fournisseur> {
	@Autowired
	FournisseurRepository fr;

	@Override
	public List<Fournisseur> retrieveAll() {
		List<Fournisseur> list = new ArrayList<Fournisseur>();
		try {
			list = (List<Fournisseur>) fr.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return list;
	}

	@Override
	public Fournisseur addItem(Fournisseur fournisseur) {
		Fournisseur f = new Fournisseur();
		try {

			f = fr.save(fournisseur);
			System.out.println("fournissuer ajouté avec succés");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return f;
	}

	@Override
	public void deleteItem(long id) {
		
			fr.deleteById(id);

		

	}

	@Override
	public Fournisseur updateItem(Fournisseur fournisseur) {
		if (fr.findById(fournisseur.getIdFournisseur()).isPresent() ) {
			return fr.save(fournisseur);
		}
		return null;
			
		
				
				
				 

		
	}

	@Override
	public Fournisseur retrieveItem(long id) {
		return fr.findById(id).get();
	}

}
