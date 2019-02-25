package com.bookstoresystem.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstoresystem.spring.model.Book;
//import com.bookstoresystem.spring.service.Session;

@Repository
public class BookDAOImp implements BookDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Book book) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> list() {
		List<Book> list =sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	@Override
	public void update(long id, Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Book oldbook = session.byId(Book.class).load(id);
		oldbook.setTitle(book.getTitle());
		oldbook.setAuthor(book.getAuthor());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

}
