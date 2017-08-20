package org.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.casadocodigo.loja.model.Book;

public class BookDAO {

	@PersistenceContext
	private EntityManager manager;

	//salvar livro
	public void save(Book product) {
		manager.persist(product);
	}

	//listagem de livros
	public List<Book> list() {

		return manager.createQuery("select distinct(b) from Book b join fetch b.authors", Book.class).getResultList();

	}

}
