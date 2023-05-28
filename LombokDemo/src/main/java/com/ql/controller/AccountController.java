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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ql.FileUploadUtil;
import com.ql.entity.Account;
import com.ql.service.AccountService;
import com.ql.service.ParamService;
import com.ql.service.SessionService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	AccountService accService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;

	public boolean checkSecurity() {
		String username = sessionService.get("USERNAME");
		if (username != null) {
			Optional<Account> account = accService.findById(username);
			// account da co san thi
			if (account.isPresent()) {
				if (account.get().getAdmin()) {
					return true;
				}
			}

		}
		return false;

	}

	@GetMapping("register")
	public String showForm(Model model) {
		model.addAttribute("ACCOUNT", new Account());
		if (checkSecurity()) {
			return "register-form";

		}
			return "redirect:/error/view";
	}

	// ham luu 1 acc
	@PostMapping(value = "SaveOrUpdate")
	public String saveorUpdate(@Validated @ModelAttribute("ACCOUNT") Account acc, BindingResult result, Model model,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {

		// kiem tra validated
		if (result.hasErrors() || multipartFile.isEmpty()) {
			// valadited photo

			model.addAttribute("ERRP", "please select Image");

			return "register-form";
		}
		// import org.springframework.util.StringUtils;
		// lay ra ten file dc user chon
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		// duong dan upload ten
		String uploadDir = "uploads/";
		acc.setPhoto(fileName);
		paramService.saveFile(uploadDir, fileName, multipartFile);
		// FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		// set lai bien photo

		accService.save(acc);
		model.addAttribute("ACCOUNT", new Account());
		return "register-form";
	}

	// account views
	@GetMapping("view")
	public String viewAccount(Model model) {
		if (checkSecurity()) {
			model.addAttribute("ACCOUNT", accService.findAll());
			return "view-acount";
		}
		return "redirect:/error/view";
	}

	// edit
	@GetMapping("register/{username}")
	public String editAccount(Model model, @PathVariable("username") String username) {

		/*
		 * Optional<Account> vi acc có thể null
		 */
		Optional<Account> account = accService.findById(username);
		// account da co san thi
		if (account.isPresent()) {
			model.addAttribute("ACCOUNT", account.get());
		} else {
			model.addAttribute("ACCOUNT", new Account());
		}
		return "register-form";
	}

	@GetMapping(value = "view", params = "btnDel")
	public String deleteAccount(Model model, @RequestParam("username") String username) {
		accService.deleteById(username);
		return "redirect:/account/view";
	}
}
