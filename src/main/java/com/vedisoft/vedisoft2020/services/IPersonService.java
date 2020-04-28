package com.vedisoft.vedisoft2020.services;

import java.util.List;


import com.vedisoft.vedisoft2020.pojos.Person;

public interface IPersonService {
	
	Person createPerson(Person person);
	Person getPersonById(Long id);
	List<Person> getAllPersons();
	void removePersonById(Long id);
}
