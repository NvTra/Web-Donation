package com.tranv.webdonation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tranv.webdonation.dto.CreaterUserDTO;
import com.tranv.webdonation.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
	}

	@Override
	public List<User> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(int userId) {

		return null;
	}

	@Override
	public void updateUser(User user) {
	}

	@Override
	public void deleteUser(int userId) {
	}

}
