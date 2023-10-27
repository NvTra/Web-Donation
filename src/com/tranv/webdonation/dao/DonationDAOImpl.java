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

@Repository
public class DonationDAOImpl implements DonationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveDonation(Donation donation) {
		Session currentSession = sessionFactory.getCurrentSession();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		donation.setCreated(formater.format(new Date()));
		currentSession.save(donation);
	}

	@Override
	public List<Donation> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Donation> query = currentSession.createQuery("from Donation", Donation.class);
		return query.getResultList();
	}

	@Override
	public Donation findById(int donationId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Donation.class, donationId);
	}

	@Override
	public void updateDonation(Donation donation) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(donation);
	}

	@Override
	public void deleteDonation(int donationId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Donation where id=:donationId");
		query.setParameter("donationId", donationId);
		query.executeUpdate();
	}

	@Override
	public void updateStatus(int donationId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Donation donation = currentSession.get(Donation.class, donationId);
		int status = donation.getStatus();
		if (status == 0) {
			donation.setStatus(1);
		} else if (status == 1) {
			donation.setStatus(2);
		} else if (status == 2) {
			donation.setStatus(3);
		}
		currentSession.update(donation);
	}

}
