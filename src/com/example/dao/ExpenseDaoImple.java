package com.example.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.Expense;

@Repository
public class ExpenseDaoImple implements ExpenseDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void insert(final Expense expense) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			public Void doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.save(expense);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	public void delete(final int expenseId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			public Void doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.delete(new Expense(expenseId));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	public Expense select(final int expenseId) {
		Expense ex = hibernateTemplate.execute(new HibernateCallback<Expense>() {

			public Expense doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Expense exp  = (Expense)session.get(Expense.class, expenseId);
				t.commit();
				session.flush();
				session.close();
				return exp;
			}
			
		});
		
		return ex;
	}

	public void update(final Expense expense) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			public Void doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.update(expense);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	public List<Expense> selectAll(int userId) {
		List<Expense> ex = hibernateTemplate.execute(new HibernateCallback<List<Expense>>() {

			public List<Expense> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Expense");
				List<Expense> li = q.list();
				t.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		
		return ex;
	}

}
