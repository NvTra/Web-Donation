package com.tranv.webdonation.dao;

import java.util.List;


import com.tranv.webdonation.entity.User;

public interface UserDAO {
	void saveUser(User user);

	List<User> findAll();

	User findById(int userId);

	void updateUser(User user);

	void deleteUser(int userId);
}
