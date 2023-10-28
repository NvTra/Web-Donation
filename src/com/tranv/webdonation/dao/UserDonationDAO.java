package com.tranv.webdonation.dao;

import java.util.List;

import com.tranv.webdonation.entity.UserDonation;

public interface UserDonationDAO {
	UserDonation findbyId(int userDonationId);

	List<UserDonation> getUserDonations();

	void createDonate(UserDonation userDonation);

	public List<UserDonation> findByDonationIdAndStatus(int theId);

	public List<UserDonation> findByDonationId(int theId);

	public void confirmDonate(int theId);

	public void unconfirmDonate(int theId);
}
