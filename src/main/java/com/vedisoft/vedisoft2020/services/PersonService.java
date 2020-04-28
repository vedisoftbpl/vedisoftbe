package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IPersonDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Person;

@Service
public class PersonService implements IPersonService {
	
	@Autowired
	private IPersonDetailsDao personDetailsDao;

	@Override
	public Person createPerson(Person person) {
		return personDetailsDao.createPerson(person);
	}

	@Override
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return personDetailsDao.getPersonById(id);
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personDetailsDao.getAllPersons();
	}

	@Override
	public void removePersonById(Long id) {
		// TODO Auto-generated method stub
		personDetailsDao.removePersonById(id);
	}

}
