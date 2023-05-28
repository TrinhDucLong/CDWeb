package com.ql.service;

import java.util.Collection;

import com.ql.entity.CartItem;

public interface ShoppingCartService {

	public double getAmount();

	public int getCount();

	public Collection<CartItem> getAllItems();

	public void clear();

	public CartItem update(int proId, int qty);

	public void remove(int id);

	public void add(CartItem item);
	// dinh nghia cac ham

}
