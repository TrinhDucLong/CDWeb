package com.ql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class test {
	@RequestMapping("f")
	public String view() {
		return"product-form";
	}
	@RequestMapping("t")
	public String views() {
		return"product-view";
	}
}
