package tn.elife.spring.services;

import java.util.List;


public interface IService<T> {
	List<T> retrieveAll();

	T addItem(T t);

	void deleteItem(long id);

	T updateItem(T t);

	Object retrieveItem(long id);

}
