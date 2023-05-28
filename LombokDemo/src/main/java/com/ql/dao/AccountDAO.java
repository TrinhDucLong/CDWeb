package com.ql.dao;

import org.springframework.data.repository.CrudRepository;

import com.ql.entity.Account;

public interface AccountDAO extends CrudRepository<Account, String> {
	

}
