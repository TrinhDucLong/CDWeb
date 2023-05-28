package com.ql.dao;

import org.springframework.data.repository.CrudRepository;

import com.ql.entity.Category;


public interface CategoryDAO extends CrudRepository <Category, String> {

}
