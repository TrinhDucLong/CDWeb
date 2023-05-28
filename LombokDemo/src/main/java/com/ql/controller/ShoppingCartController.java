package com.ql.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ql.entity.CartItem;
import com.ql.entity.Product;
import com.ql.service.EmailService;
import com.ql.service.ParamService;
import com.ql.service.ProductService;
import com.ql.service.ShoppingCartService;

import jakarta.mail.MessagingException;

@Controller
@RequestMapping("shopping")
public class ShoppingCartController {

	@Autowired
	ParamService paramService;

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartService cartService;

	@Autowired
	EmailService emailService;

	@GetMapping("views")
	public String viewCart(Model model) {
		model.addAttribute("CART_ITEMS", cartService.getAllItems());
		model.addAttribute("TOTAL", cartService.getAmount());
		return "cart-items";
	}

	@GetMapping("add/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		Optional<Product> p = productService.findById(id);
		if (p.isPresent()) {
			CartItem item = new CartItem();
			Product product = p.get();

			item.setProductId(product.getId());
			item.setName(product.getName());
			item.setPrice(product.getPrice());
			item.setQty(1);

			cartService.add(item);
		}
		return "redirect:/shopping/views";
	}

	@GetMapping("clear")
	public String clearCart() {
		cartService.clear();
		return "redirect:/shopping/views";
	}

	@GetMapping("del/{id}")
	public String removeCart(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/shopping/views";
	}

	@PostMapping("update")
	public String update(@RequestParam("id") Integer id, @RequestParam("qty") Integer qty) {
		cartService.update(id, qty);
		return "redirect:/shopping/views";
	}

	@GetMapping("form")
	public String payform() {
		return "pay";
	}

	@PostMapping("pay")
	
	public String sendmail(Model model) throws MessagingException {
		String address = paramService.getString("address", "");
		String mail = paramService.getString("email", "");
		emailService.sendSimpleMail(mail, "cam on ban da dat hang :" +"day co phai la dia chi cua ban la " + address , "xac nhan dia chi dat hang qua mail");
		return "redirect:/shopping/views";
	}

}
