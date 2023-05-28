package com.ql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ql.entity.Product;


public interface ProductDAO extends JpaRepository<Product, Integer> {

}
