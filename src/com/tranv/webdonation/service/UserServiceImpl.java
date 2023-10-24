package com.tranv.webdonation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tranv.webdonation.dao.UserDAO;
import com.tranv.webdonation.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int userId) {
		return userDAO.findById(userId);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}

}
