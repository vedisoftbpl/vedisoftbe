package com.vedisoft.vedisoft2020.services;

import com.vedisoft.vedisoft2020.pojos.Person;

public interface IUserDetailsService {
	Person getActiveUserDetails(String username);
}
