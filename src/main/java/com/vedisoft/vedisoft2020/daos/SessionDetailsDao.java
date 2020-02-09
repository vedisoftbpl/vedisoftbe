package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.jparepository.SessionJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Session;

@Repository
@Transactional
public class SessionDetailsDao implements ISessionDetailsDao{
	
	@Autowired
	private SessionJpaRepository sessionJpaRepository;

	@Override
	public List<Session> getAllSessions() {
		// TODO Auto-generated method stub
		return sessionJpaRepository.findAll();
	}

	@Override
	public Session getSessionById(Long id) {
		// TODO Auto-generated method stub
		return sessionJpaRepository.findById(id).get();
	}

//	@Override
//	public Session removeSessionById(Long id) {
//		// TODO Auto-generated method stub
//		return sessionJpaRepository.deleteById(id);
//	}

	@Override
	public Session createSession(Session session) {
		// TODO Auto-generated method stub
		return sessionJpaRepository.save(session);
	}
	
	
}
