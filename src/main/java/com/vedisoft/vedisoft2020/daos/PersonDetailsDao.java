package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.jparepository.PersonJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Person;

@Repository
@Transactional
public class PersonDetailsDao implements IPersonDetailsDao {
	
	@Autowired
	private PersonJpaRepository personJpaRepository;

	@Override
	public List<Person> getAllPersons() {
		return personJpaRepository.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return personJpaRepository.findById(id).get();
	}

	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		if(person.getPersonId() == -1)
			person.setPersonId((long)0);
		return personJpaRepository.save(person);
	}

	@Override
	public void removePersonById(Long id) {
		// TODO Auto-generated method stub
		personJpaRepository.deleteById(id);
	}
	
}
