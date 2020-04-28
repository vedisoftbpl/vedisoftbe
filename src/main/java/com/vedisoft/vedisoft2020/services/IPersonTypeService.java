package com.vedisoft.vedisoft2020.services;

import java.util.List;
import com.vedisoft.vedisoft2020.pojos.PersonType;

public interface IPersonTypeService {
	PersonType createPersonType(PersonType personType);
	PersonType getPersonTypeById(Long id);
	List<PersonType> getAllPersonTypes();
	void removePersonTypeById(Long id);
}
