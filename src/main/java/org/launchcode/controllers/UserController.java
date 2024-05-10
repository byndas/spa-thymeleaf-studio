package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.launchcode.models.User;

@Controller
@RequestMapping("user")
public class UserController {

	@GetMapping("add")
	public String displayAddUserForm() {
		return "user/add";
	}

	@PostMapping("add")
	public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {

		if (user.getPassword().equals(verify)) {
//			                            let username = user.getUsername();
			model.addAttribute("username", user.getUsername());
			return "user/index";
		}
		return "user/add";
	}
}