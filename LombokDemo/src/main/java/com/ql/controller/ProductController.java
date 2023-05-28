package com.ql.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ql.entity.Account;
import com.ql.entity.CartItem;
import com.ql.entity.Product;
import com.ql.service.AccountService;
import com.ql.service.ParamService;
import com.ql.service.ProductService;
import com.ql.service.SessionService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService service;
	@Autowired
	SessionService sessionService;
	@Autowired
	ParamService paramService;
	@Autowired
	AccountService accService;

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

	@GetMapping("views")
	public String viewProduct(Model model, @RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("price"));
		// sap xep theo gia giam dan
		List<Product> lsProduct = service.findAll(sort);
		model.addAttribute("LIST_PRODUCT", lsProduct);
		return "view-product";

	}

//	public boolean checkSecurity() {
//		String username = sessionService.get("USERNAME");
//		if (username != null) {
//			return true;
//		}
//		return false;
//
//	}
	@GetMapping("views/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		/**
		 * 10 so san pham tren 1 tran p bao nhieu trang p null thi md la trang ddau ien
		 */
		Pageable pageable = PageRequest.of(p.orElse(0), 12);
		Page<Product> page = service.findAll(pageable);
		model.addAttribute("LIST_PRODUCT", page);
		return "view-product";

	}

	@GetMapping("detail/{id}")
	public String viewdetail(Model model, @PathVariable("id") Integer id) {
		Optional<Product> p = service.findById(id);
		if (p.isPresent()) {
			model.addAttribute("p", p.get());
			return "detail";
		}
		return "view-product";

	}

	// tra ve product-form
	@GetMapping("form")
	public String showForm(Model model) {
		model.addAttribute("PRODUCT", new Product());
		if (checkSecurity()) {
			return "product-form";
		}
		return "redirect:/error/view";
	}

	// account views
	@GetMapping("manager")
	public String viewsProduct(Model model, @RequestParam("field") Optional<String> field) {

		if (checkSecurity()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("price"));
			// sap xep theo gia giam dan
			List<Product> lsProduct = service.findAll(sort);
			model.addAttribute("PRODUCT", lsProduct);
			return "product-view";
		}
		return "redirect:/error/view";
	}

	// them 1 san pham moi hoac update
	// ham luu 1 acc
	@PostMapping(value = "SaveOrUpdate")
	public String saveorUpdate(@Validated @ModelAttribute("PRODUCT") Product product, BindingResult result, Model model,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {

		if (result.hasErrors() || multipartFile.isEmpty()) {
			model.addAttribute("ERRP", "please select Image");
			return "product-form";
		}
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		// duong dan upload ten
		String uploadDir = "uploads/";
		product.setImage(fileName);
		paramService.saveFile(uploadDir, fileName, multipartFile);
		// FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		// set lai bien photo
		service.save(product);
		model.addAttribute("PRODUCT", new Product());
		return "product-form";
	}

	// edit
	@GetMapping("manager/{id}")
	public String editAccount(Model model, @PathVariable("id") Integer id) {

		/*
		 * Optional<Account> vi acc có thể null
		 */
		Optional<Product> p = service.findById(id);

		// account da co san thi
		if (p.isPresent()) {
			model.addAttribute("PRODUCT", p.get());
		} else {
			model.addAttribute("PRODUCT", new Account());
		}
		return "product-form";
	}

	// xoa
	@GetMapping(value = "manager", params = "btnDel")
	public String deleteAccount(Model model, @RequestParam("id") Integer id) {
		service.deleteById(id);
		return "redirect:/product/manager";
	}
}
