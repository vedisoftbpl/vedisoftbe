package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vedisoft.vedisoft2020.daos.IPersonTypeDetailsDao;
import com.vedisoft.vedisoft2020.pojos.PersonType;

@Service
public class PersonTypeService implements IPersonTypeService {
	@Autowired
	private IPersonTypeDetailsDao personTypeDetailsDao;

	@Override
	public PersonType createPersonType(PersonType personType) {
		return personTypeDetailsDao.createPersonType(personType);
	}

	@Override
	public PersonType getPersonTypeById(Long id) {
		// TODO Auto-generated method stub
		return personTypeDetailsDao.getPersonTypeById(id);
	}

	@Override
	public List<PersonType> getAllPersonTypes() {
		// TODO Auto-generated method stub
		return personTypeDetailsDao.getAllPersonTypes();
	}

	@Override
	public void removePersonTypeById(Long id) {
		// TODO Auto-generated method stub
		personTypeDetailsDao.removePersonTypeById(id);
	}

}
