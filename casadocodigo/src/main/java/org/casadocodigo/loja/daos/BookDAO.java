package org.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.casadocodigo.loja.model.Book;

public class BookDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Book product) {
		manager.persist(product);
	}

}
