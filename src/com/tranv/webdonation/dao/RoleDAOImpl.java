package com.tranv.webdonation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tranv.webdonation.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findById(int roleId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Role.class, roleId);
	}

}
