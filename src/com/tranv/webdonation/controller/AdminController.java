package com.tranv.webdonation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranv.webdonation.entity.User;
import com.tranv.webdonation.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String adminHome() {
		return "/admin/home";
	}

	@RequestMapping("/account")
	public String listUser(Model model) {
		List<User> getUsers = userService.findAll();
		model.addAttribute("users", getUsers);
		return "admin/account";
	}

	@RequestMapping("/donation")
	public String listDonation() {
		return "admin/donation";
	}

}
