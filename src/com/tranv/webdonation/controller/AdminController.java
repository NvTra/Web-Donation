package com.tranv.webdonation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranv.webdonation.dto.CreaterUserDTO;
import com.tranv.webdonation.entity.Role;
import com.tranv.webdonation.entity.User;
import com.tranv.webdonation.service.RoleService;
import com.tranv.webdonation.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("/")
	public String adminHome() {
		return "/admin/home";
	}

// Admin Manager
	@GetMapping("/account")
	public String listUser(Model model) {
		List<User> getUsers = userService.findAll();
		List<Role> getRoles = roleService.getRoles();
		model.addAttribute("roleList", getRoles);
		model.addAttribute("users", getUsers);
		model.addAttribute("newUser", new CreaterUserDTO());
		return "admin/account";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("newUser") CreaterUserDTO userDTO) {
		userService.saveUser(userDTO);
		return "redirect:/admin/account";
	}

	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/admin/account";
	}

	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		userService.deleteUser(userId);
		return "redirect:/admin/account";
	}

	@PostMapping("/lockUser")
	public String lockUser(@RequestParam("userId") int userId) {
		userService.lockUser(userId);
		return "redirect:/admin/account";
	}

//	Donation Manager
	@RequestMapping("/donation")
	public String listDonation() {
		return "admin/donation";
	}

}
