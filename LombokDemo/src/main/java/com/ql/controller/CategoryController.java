package com.ql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ql.dao.CategoryDAO;
import com.ql.service.CategoryService;

@Controller
@RequestMapping("categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	@GetMapping("view")
	public String view(Model model) {
		model.addAttribute("listCC", categoryService.findAll());
		return "category";
	}
	
		
	
}
