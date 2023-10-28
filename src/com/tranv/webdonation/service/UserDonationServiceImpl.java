package com.tranv.webdonation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tranv.webdonation.dao.UserDonationDAO;
import com.tranv.webdonation.entity.UserDonation;

@Service
public class UserDonationServiceImpl implements UserDonationService {

	@Autowired
	private UserDonationDAO userDonationDAO;

	@Override
	@Transactional
	public UserDonation findbyId(int userDonationId) {
		return userDonationDAO.findbyId(userDonationId);
	}

	@Override
	@Transactional
	public List<UserDonation> getUserDonations() {
		return userDonationDAO.getUserDonations();
	}

	@Override
	@Transactional
	public void createDonate(UserDonation userDonation) {
		userDonationDAO.createDonate(userDonation);
	}

	@Override
	@Transactional
	public List<UserDonation> findByDonationIdAndStatus(int theId) {
		return userDonationDAO.findByDonationIdAndStatus(theId);
	}

	@Override
	@Transactional
	public List<UserDonation> findByDonationId(int theId) {
		return userDonationDAO.findByDonationId(theId);
	}

	@Override
	@Transactional
	public void confirmDonate(int theId) {
		userDonationDAO.confirmDonate(theId);
	}

	@Override
	@Transactional
	public void unconfirmDonate(int theId) {
		userDonationDAO.unconfirmDonate(theId);
	}

}
