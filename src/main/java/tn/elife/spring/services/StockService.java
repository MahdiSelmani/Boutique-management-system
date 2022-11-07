package tn.elife.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.elife.spring.entities.Stock;
import tn.elife.spring.repository.StockRepository;

@Service
public class StockService implements IService<Stock> {
	@Autowired
	StockRepository sr;

	@Override
	public List<Stock> retrieveAll() {
		return (List<Stock>) sr.findAll();
	}

	@Override
	public Stock addItem(Stock t) {
		System.out.println("Stock ajouté avec succés");
		return sr.save(t);
	}

	@Override
	public void deleteItem(long id) {
		sr.deleteById(id);

	}

	@Override
	public Stock updateItem(Stock t) {
		return sr.save(t);
	}

	@Override
	public Stock retrieveItem(long id) {
		Object n = sr.findById(id);
		return (Stock) n;
	}

}
