package com.ql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ql.entity.Product;

public interface ProductService {

	void deleteAll();

	void deleteAll(List<Product> entities);

	void deleteAllById(List<Integer> ids);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> findAllById(List<Integer> ids);

	List<Product> findAll();

	Page<Product> findAll(Pageable pageable);

	List<Product> findAll(Sort sort);

	List<Product> saveAll(List<Product> entities);

	Product save(Product entity);

	
}
