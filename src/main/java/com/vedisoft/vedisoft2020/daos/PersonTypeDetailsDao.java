package com.vedisoft.vedisoft2020.daos;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vedisoft.vedisoft2020.jparepository.PersonTypeJpaRepository;
import com.vedisoft.vedisoft2020.pojos.PersonType;

@Repository
@Transactional
public class PersonTypeDetailsDao implements IPersonTypeDetailsDao {
	
	@Autowired
	private PersonTypeJpaRepository personTypeJpaRepository;

	@Override
	public List<PersonType> getAllPersonTypes() {
		return personTypeJpaRepository.findAll();
	}

	@Override
	public PersonType getPersonTypeById(Long id) {
		return personTypeJpaRepository.findById(id).get();
	}

	@Override
	public PersonType createPersonType(PersonType personType) {
		// TODO Auto-generated method stub
		personType.setPid((long)0);
		return personTypeJpaRepository.save(personType);
	}

	@Override
	public void removePersonTypeById(Long id) {
		// TODO Auto-generated method stub
		personTypeJpaRepository.deleteById(id);
	}


}
