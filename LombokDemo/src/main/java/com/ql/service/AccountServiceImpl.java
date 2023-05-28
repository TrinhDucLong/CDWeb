package com.ql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ql.dao.AccountDAO;
import com.ql.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO accDAO;

	@Override
	public Account save(Account entity) {
		return accDAO.save(entity);
	}

	@Override
	public List<Account> saveAll(List<Account>entities) {
		return (List<Account>)accDAO.saveAll(entities);
	}

	/*
	 *   Optional<Account> findById(String id) có thể null
	 */
	@Override
	public Optional<Account> findById(String id) {
		return accDAO.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return accDAO.existsById(id);
	}

	@Override
	public List<Account> findAll() {
		return (List<Account>)accDAO.findAll();
	}

	@Override
	public List<Account> findAllById(List<String> ids) {
		return (List<Account>) accDAO.findAllById(ids);
	}

	@Override
	public long count() {
		return accDAO.count();
	}

	@Override
	public void deleteById(String id) {
		accDAO.deleteById(id);
	}

	@Override
	public void delete(Account entity) {
		accDAO.delete(entity);
	}

	@Override
	public void deleteAllById(List<String> ids) {
		accDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Account> entities) {
		accDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		accDAO.deleteAll();
	}
	
	
}
