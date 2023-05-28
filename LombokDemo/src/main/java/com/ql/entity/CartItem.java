package com.ql.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	private Integer productId;
	private String name;
	private double price;
	private int qty = 1;

}
