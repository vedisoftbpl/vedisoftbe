package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.vedisoft.vedisoft2020.pojos.PersonType;

@Repository
public interface IPersonTypeDetailsDao {
	List<PersonType> getAllPersonTypes();
	PersonType getPersonTypeById(Long id);
	PersonType createPersonType(PersonType personType);
	void removePersonTypeById(Long id);

}
