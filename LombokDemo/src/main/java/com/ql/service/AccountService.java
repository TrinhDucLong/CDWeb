package com.ql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ql.entity.Account;


public interface AccountService {

	void deleteAll();

	void deleteAll(List<Account> entities);

	void deleteAllById(List<String> ids);

	void delete(Account entity);

	void deleteById(String id);

	long count();

	List<Account> findAllById(List<String> ids);

	List<Account> findAll();

	boolean existsById(String id);

	Optional<Account> findById(String id);

	List<Account> saveAll(List<Account>entities);

	public Account save(Account entity);

}
