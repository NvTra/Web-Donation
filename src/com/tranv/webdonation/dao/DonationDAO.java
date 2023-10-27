package com.tranv.webdonation.dao;

import java.util.List;

import com.tranv.webdonation.entity.Donation;

public interface DonationDAO {
	void saveDonation(Donation donation);

	List<Donation> findAll();

	Donation findById(int donationId);

	void updateDonation(Donation donation);

	void deleteDonation(int donationId);

	void updateStatus(int donationId);
}
