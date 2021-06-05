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

import com.example.dto.User;

@Repository
public class UserDaoImple implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void registration(User user) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.save(user);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public boolean login(User user) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from User where email = ? and password=?");
				q.setString(0, user.getEmail());
				q.setString(1, user.getPassword());
				List<User> li = q.list();
				if(!li.isEmpty()) {
					user.setUserId(li.get(0).getUserId()); 
				}
				t.commit();
				session.flush();
				session.close();
				return !li.isEmpty();
			}
			
		});
		return b;
	}
	
}
