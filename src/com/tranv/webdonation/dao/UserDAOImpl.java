package com.tranv.webdonation.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tranv.webdonation.dto.CreaterUserDTO;
import com.tranv.webdonation.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(CreaterUserDTO userDTO) {
		User newUser = userDTOToEntity(userDTO);
		newUser.setStatus(1);
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		newUser.setCreated(formater.format(new Date()));
		newUser.setRole(roleDAO.findById(userDTO.getRoleId()));
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(newUser);
	}

	@Override
	public List<User> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(User.class, userId);
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(user);
	}

	@Override
	public void deleteUser(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

	@Override
	public void lockUser(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, userId);
		if (user.getStatus() == 0) {
			user.setStatus(1);
		} else {
			user.setStatus(0);
		}

	}

	private User userDTOToEntity(CreaterUserDTO dto) {
		User newUser = new User();
		newUser.setFullName(dto.getFullName());
		newUser.setEmail(dto.getEmail());
		newUser.setPhoneNumber(dto.getPhoneNumber());
		newUser.setAddress(dto.getAddress());
		newUser.setUserName(dto.getUserName());
		newUser.setPassword(dto.getPassword());
		return newUser;
	}
}
