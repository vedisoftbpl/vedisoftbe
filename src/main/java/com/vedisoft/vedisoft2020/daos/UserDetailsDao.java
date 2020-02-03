package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.pojos.Person;

@Repository
@Transactional
public class UserDetailsDao implements IUserDetailsDao {
	
	@PersistenceContext
	private EntityManager entityManager ;
	
	
	public Person getActiveUser(String username) {
		Person activePersonDetails = new Person();
		byte active = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM Person u WHERE username=?1 and active=?2")
				.setParameter(1, username).setParameter(2, active).getResultList();
		if(!list.isEmpty()) {
			activePersonDetails = (Person)list.get(0);
		}
		return activePersonDetails;

	}
				
		
}
