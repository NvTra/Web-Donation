package com.tranv.webdonation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tranv.webdonation.dao.DonationDAO;
import com.tranv.webdonation.entity.Donation;

@Service
public class DonationServiceImpl implements DonationService {
	@Autowired
	private DonationDAO donationDAO;

	@Override
	@Transactional
	public void saveDonation(Donation donation) {
		donationDAO.saveDonation(donation);
	}

	@Override
	@Transactional
	public List<Donation> findAll() {
		return donationDAO.findAll();
	}

	@Override
	@Transactional
	public Donation findById(int donationId) {
		return donationDAO.findById(donationId);
	}

	@Override
	@Transactional
	public void updateDonation(Donation donation) {
		donationDAO.updateDonation(donation);
	}

	@Override
	@Transactional
	public void deleteDonation(int donationId) {
		donationDAO.deleteDonation(donationId);
	}

	@Override
	@Transactional
	public void updateStatus(int donationId) {
		donationDAO.updateStatus(donationId);
	}

}
