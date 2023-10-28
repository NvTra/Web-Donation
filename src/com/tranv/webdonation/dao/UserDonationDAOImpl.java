package com.tranv.webdonation.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tranv.webdonation.entity.Donation;
import com.tranv.webdonation.entity.UserDonation;

@Repository
public class UserDonationDAOImpl implements UserDonationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DonationDAO donationDAO;

	@Override
	public UserDonation findbyId(int userDonationId) {
		return donationDAO.findbyId(userDonationId);
	}

	@Override
	public List<UserDonation> getUserDonations() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserDonation> query = currentSession.createQuery("from UserDonation", UserDonation.class);
		return query.getResultList();
	}

	@Override
	public void createDonate(UserDonation userDonation) {
		Session currentSession = sessionFactory.getCurrentSession();
		Donation theDonation = donationDAO.findById(userDonation.getDonation().getId());
		SimpleDateFormat fomat = new SimpleDateFormat("dd/MM/yyyy");
		userDonation.setCreated(fomat.format(new Date()));
		userDonation.setStatus(0);
		userDonation.setDonation(theDonation);
		currentSession.save(userDonation);
	}

	@Override
	public List<UserDonation> findByDonationIdAndStatus(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserDonation> query = currentSession.createQuery(
				"SELECT u FROM UserDonation u JOIN u.donation d WHERE d.id =:donationId AND u.status = 1",
				UserDonation.class);
		query.setParameter("donationId", theId);
		return query.getResultList();
	}

	@Override
	public List<UserDonation> findByDonationId(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserDonation> theQuery = currentSession.createQuery(
				"SELECT u FROM UserDonation u JOIN u.donation d WHERE d.id =:donationId", UserDonation.class);
		theQuery.setParameter("donationId", theId);
		return theQuery.getResultList();
	}

	@Override
	public void confirmDonate(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		UserDonation userDonation = currentSession.get(UserDonation.class, theId);
		Donation donation = userDonation.getDonation();
		userDonation.setStatus(1);
		donation.totalMoney(userDonation.getMoney());
		currentSession.update(donation);
		currentSession.update(userDonation);
	}

	@Override
	public void unconfirmDonate(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		UserDonation userDonation = currentSession.get(UserDonation.class, theId);
		userDonation.setStatus(2);
	}

}
