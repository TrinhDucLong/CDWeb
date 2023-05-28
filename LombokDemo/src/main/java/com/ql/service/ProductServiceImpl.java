package com.ql.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.ql.dao.ProductDAO;
import com.ql.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;


	@Override
	public Product save(Product entity) {
		return productDAO.save(entity);
	}

	@Override
	public List<Product> saveAll(List<Product> entities) {
		return (List<Product>) productDAO.saveAll(entities);
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productDAO.findAll(sort);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDAO.findAll(pageable);
	}

	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	public List<Product> findAllById(List<Integer> ids) {
		return (List<Product>) productDAO.findAllById(ids);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productDAO.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return productDAO.existsById(id);
	}

	@Override
	public long count() {
		return productDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDAO.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		productDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Product> entities) {
		productDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDAO.deleteAll();
	}

}
