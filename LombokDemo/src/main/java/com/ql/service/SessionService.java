package com.ql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
	@Autowired
	HttpSession session;

	/**
	 * doc gia tri cua attribute trong session
	 * 
	 * @param name teen attribute
	 * @return grti hoac null
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) session.getAttribute(name);
	}

	/**
	 * thay doi hoac tao moi 1 attribute trong session
	 * 
	 * @param <T>
	 * @param name ten attribute
	 * @return grti attribute
	 */
	public <T> T get(String name, T defaultValue) {
		T value = get(name);
		return value != null ? value : defaultValue;
	}

	/**
	 * thay doi hoac tao moi
	 * 
	 * @param name
	 * @param value
	 */
	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}

	/**
	 * xoa attribute co trong session
	 * 
	 * @param name ten attribute can xoa
	 */
	public void remove(String name) {
		session.removeAttribute(name);
	}
}
