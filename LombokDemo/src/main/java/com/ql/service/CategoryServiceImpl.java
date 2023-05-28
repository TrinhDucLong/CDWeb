package com.ql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ql.dao.CategoryDAO;
import com.ql.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public  Category save(Category entity) {
		return categoryDAO.save(entity);
	}

	@Override
	public List<Category> saveAll(List<Category> entities) {
		return (List<Category>) categoryDAO.saveAll(entities);
	}

	@Override
	public Optional<Category> findById(String id) {
		return categoryDAO.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return categoryDAO.existsById(id);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>)categoryDAO.findAll();
	}

	@Override
	public  List<Category> findAllById(List<String> ids) {
		return ( List<Category> )categoryDAO.findAllById(ids);
	}

	@Override
	public long count() {
		return categoryDAO.count();
	}

	@Override
	public void deleteById(String id) {
		categoryDAO.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryDAO.delete(entity);
	}

	@Override
	public void deleteAllById(List<String> ids) {
		categoryDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Category> entities) {
		categoryDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryDAO.deleteAll();
	}
	

}
