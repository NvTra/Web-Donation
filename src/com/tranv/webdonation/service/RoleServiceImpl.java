package com.tranv.webdonation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tranv.webdonation.dao.RoleDAO;
import com.tranv.webdonation.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDAO;

	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

}
