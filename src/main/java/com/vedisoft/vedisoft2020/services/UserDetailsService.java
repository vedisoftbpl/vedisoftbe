package com.vedisoft.vedisoft2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IUserDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Person;

@Service
public class UserDetailsService implements IUserDetailsService {
	
	@Autowired
	private IUserDetailsDao userDetailsDao;
	
	@Override
	public Person getActiveUserDetails(String username) {
		// TODO Auto-generated method stub
		return userDetailsDao.getActiveUser(username);
	}

}
