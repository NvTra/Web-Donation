package com.tranv.webdonation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranv.webdonation.entity.Donation;
import com.tranv.webdonation.entity.UserDonation;
import com.tranv.webdonation.service.DonationService;
import com.tranv.webdonation.service.UserDonationService;

@Controller
public class HomeController {
	@Autowired
	private DonationService donationService;
	@Autowired
	private UserDonationService userDonationService;

	@RequestMapping("/")
	public String showHome(@RequestParam(name = "page", defaultValue = "1") int currentPage, Model theModel) {
		List<Donation> donations = donationService.findAll();
		pagination(donations, currentPage, theModel, "donations");
		return "public/home";
	}

	@GetMapping("/detailDonation/{donationId}")
	public String detailDonation(@PathVariable int donationId, Model model) {
		List<UserDonation> userDonations = userDonationService.findByDonationIdAndStatus(donationId);
		Donation donation = donationService.findById(donationId);
		model.addAttribute("donation", donation);
		model.addAttribute("userDonationList", userDonations);
		return "public/detail";
	}

	@PostMapping("/createDonate")
	public String createDonation(@ModelAttribute("userDonate") UserDonation userDonation) {
		userDonationService.createDonate(userDonation);
		return "redirect:/";
	}

	@GetMapping("/confirmDonate")
	public String confirmDonate(@RequestParam("userDonationId") int theId, Model theModel) {
		userDonationService.confirmDonate(theId);
		UserDonation theUserDonation = userDonationService.findbyId(theId);
		int donationId = theUserDonation.getDonation().getId();
		return "redirect:/admin/detailDonation/" + donationId;
	}

	@GetMapping("/unConfirmDonate")
	public String unconfirmDonate(@RequestParam("userDonationId") int theId, Model theModel) {
		userDonationService.unconfirmDonate(theId);
		UserDonation theUserDonation = userDonationService.findbyId(theId);
		int donationId = theUserDonation.getDonation().getId();
		return "redirect:/admin/detailDonation/" + donationId;
	}

	public <T> void pagination(List<T> list, int currentPage, Model theModel, String nameModel) {
		int itemsPerPage = 5;
		int totalPages = (int) Math.ceil((double) list.size() / itemsPerPage);
		int startIndex = (currentPage - 1) * itemsPerPage;
		List<T> currentPageDonations = list.subList(startIndex, Math.min(startIndex + itemsPerPage, list.size()));
		theModel.addAttribute("currentPage", currentPage);
		theModel.addAttribute("totalPages", totalPages);
		theModel.addAttribute(nameModel, currentPageDonations);
	}
}
