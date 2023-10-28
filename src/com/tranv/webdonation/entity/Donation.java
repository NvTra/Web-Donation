package com.tranv.webdonation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donation")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "description")
	private String description;

	@Column(name = "money")
	private int money;

	@Column(name = "created")
	private String created;

	@Column(name = "status")
	private int status;

	@OneToMany(mappedBy = "donation")
	private List<UserDonation> userDonations;

	public void totalMoney(int balance) {
		this.money += balance;
	}
}
