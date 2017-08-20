package org.casadocodigo.loja.managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.casadocodigo.loja.daos.AuthorDAO;
import org.casadocodigo.loja.daos.BookDAO;
import org.casadocodigo.loja.infra.MessagesHelper;
import org.casadocodigo.loja.model.Author;
import org.casadocodigo.loja.model.Book;

@Model
public class AdminBooksBean {

	private Book product = new Book();
	private List<Integer> selectedAuthorsIds = new ArrayList<>();
	private List<Author> authors = new ArrayList<Author>();

	public AdminBooksBean() {
	}

	@Inject
	public AdminBooksBean(AuthorDAO authorDAO, BookDAO bookDAO) {
		this.bookDAO = bookDAO;
		this.authors = authorDAO.list();
	}

	@Inject
	private BookDAO bookDAO;

	@Inject
	private MessagesHelper messagesHelper;

	@Transactional
	public String save() {

		populateBookAuthor();
		bookDAO.save(product);

		messagesHelper.addFlash(new FacesMessage("Livro Salvo com Sucesso!!!!"));

		return "/livros/lista?faces-redirect=true";
	}

	public Book getProduct() {

		return product;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	private void populateBookAuthor() {
		selectedAuthorsIds.stream().map((id) -> {
			return new Author(id);
		}).forEach(product::add);
	}

	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}

	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}

}
