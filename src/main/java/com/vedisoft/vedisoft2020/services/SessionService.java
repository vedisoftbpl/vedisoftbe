package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.ISessionDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Session;

@Service
public class SessionService implements ISessionService {
	@Autowired
	private ISessionDetailsDao sessionDetailDao;
	
	@Override
	public List<Session> getAllSessions() {
		return sessionDetailDao.getAllSessions();
	}

	@Override
	public Session getSessionById(Long id) {
		return sessionDetailDao.getSessionById(id);
	}
	
	@Override
	public Session createSession(Session session) {
		return sessionDetailDao.createSession(session);
		
	}
}
