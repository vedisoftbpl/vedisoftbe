package com.vedisoft.vedisoft2020.daos;

import com.vedisoft.vedisoft2020.pojos.Person;

public interface IUserDetailsDao {
	Person getActiveUser(String userName);
}
