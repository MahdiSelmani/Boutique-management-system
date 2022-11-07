package tn.elife.spring.services;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Produit;
import tn.elife.spring.entities.Stock;
import tn.elife.spring.repository.ProduitRepository;
import tn.elife.spring.repository.StockRepository;

@Service
public class ProduitService implements IService<Produit> {
	@Autowired
	ProduitRepository pr;
	@Autowired
	StockRepository sr;
	
	

	@Override
	public List<Produit> retrieveAll() {
		return (List<Produit>) pr.findAll();
	}

	@Override
	public Produit addItem(Produit t) {
		return pr.save(t);
	}

	@Override
	public void deleteItem(long id) {
		pr.deleteById(id);
	}

	@Override
	public Produit updateItem(Produit t) {
		if (pr.findById(t.getIdProduit()).isPresent())

			return pr.save(t);

		return null;
	}

	@Override
	public Object retrieveItem(long id) {
		Object n = pr.findById(id);
		return n;
	}
	
	//public void assignProduitToStock(Long idProduit, Long idStock) {
	//	pr.assignProduitToStock(idProduit, idStock);
		
	//}
	
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = pr.findById(idProduit).orElse(null);
		Stock s = sr.findById(idStock).orElse(null);
		p.setStock(s);
		pr.save(p);
	}

}
