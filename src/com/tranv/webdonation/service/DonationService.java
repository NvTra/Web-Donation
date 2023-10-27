package com.tranv.webdonation.service;

import java.util.List;

import com.tranv.webdonation.entity.Donation;

public interface DonationService {
	void saveDonation(Donation donation);

	List<Donation> findAll();

	Donation findById(int donationId);

	void updateDonation(Donation donation);

	void deleteDonation(int donationId);

	void updateStatus(int donationId);
}
