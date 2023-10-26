package com.tranv.webdonation.dao;

import java.util.List;

import com.tranv.webdonation.entity.Role;

public interface RoleDAO {
	Role findById(int roleId);

	List<Role> getRoles();
}
