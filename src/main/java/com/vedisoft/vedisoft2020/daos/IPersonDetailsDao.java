package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.vedisoft.vedisoft2020.pojos.Person;

@Repository
public interface IPersonDetailsDao {
	List<Person> getAllPersons();
	Person getPersonById(Long id);
	Person createPerson(Person person);
	void removePersonById(Long id);

}
