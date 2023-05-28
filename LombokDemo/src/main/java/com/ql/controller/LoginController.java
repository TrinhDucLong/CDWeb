package com.ql.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ql.entity.Account;
import com.ql.service.AccountService;
import com.ql.service.ParamService;
import com.ql.service.SessionService;

@Controller
@RequestMapping("home")
public class LoginController {
	@Autowired
	ParamService paramService;
	@Autowired
	AccountService accService;
	@Autowired
	SessionService sessionService;

	@GetMapping("form")
	public String viewlogin() {
		return "login-form";
	}

	@PostMapping("login")
	public String login(Model model) {
		String u = paramService.getString("username", "");
		String p = paramService.getString("password", "");

		try {
			Optional<Account> account = accService.findById(u);
			if (account.isPresent()) {
				if (!account.get().getPassword().equals(p)) {
					model.addAttribute("MESSAGE", "Invalid password or username");
				} else {
					String uri = sessionService.get("security-uri");
					if (uri != null) {
						return "redirect:" + uri;
					} else {
						model.addAttribute("MESSAGE", "Login Successfull");
						sessionService.set("USERNAME", u);
						
						// quyen admin
						if (account.get().getAdmin()) {
							return "redirect:/account/view";
						}
						return "redirect:/product/views/page";
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("MESSAGE", "Invalid password or username");
		}

		return "login-form";

	}

	@GetMapping("logout")
	public String logout(Model model) {
		sessionService.remove("USERNAME");
		return "login-form";

	}

	@GetMapping("register")
	public String viewregister(Model model) {
		model.addAttribute("ACCOUNT", new Account());
		return "register";
	}

	// ham luu 1 acc
	@PostMapping(value = "register")
	public String registerAccount(@Validated @ModelAttribute("ACCOUNT") Account acc, BindingResult result,
			Model model) {
		String username =acc.getUsername();
		Optional<Account> account = accService.findById(username);
		// kiem tra validated
		if (result.hasErrors()) {
			return "register";
		} 
		if (account.isPresent()) {
			model.addAttribute("ERRU", "Username already exists");
			
		} else {
			acc.setActivated(true);
			acc.setPhoto("user.png");
			acc.setAdmin(false);
			accService.save(acc);
			model.addAttribute("ACCOUNT", new Account());
		}
		return "register";
	}
}
