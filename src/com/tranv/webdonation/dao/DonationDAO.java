package com.tranv.webdonation.dao;

import java.util.List;

import com.tranv.webdonation.entity.Donation;
import com.tranv.webdonation.entity.UserDonation;

public interface DonationDAO {
	UserDonation findbyId(int userDonationId);

	void saveDonation(Donation donation);

	List<Donation> findAll();

	Donation findById(int donationId);

	void updateDonation(Donation donation);

	void deleteDonation(int donationId);

	void updateStatus(int donationId);
}
