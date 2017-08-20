package org.casadocodigo.loja.managedBeans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.casadocodigo.loja.daos.BookDAO;
import org.casadocodigo.loja.model.Book;

@Model
public class AdminBooksBean {

	private Book product = new Book();

	@Inject
	private BookDAO bookDAO;

	@Transactional
	public void save() {

		bookDAO.save(product);

	}

	public Book getProduct() {

		return product;
	}

}
