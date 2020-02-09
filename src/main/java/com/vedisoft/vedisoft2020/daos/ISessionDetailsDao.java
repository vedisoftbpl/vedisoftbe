package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Session;

public interface ISessionDetailsDao {
	
	List<Session> getAllSessions();
	Session getSessionById(Long id);
//	Session removeSessionById(Long id);
	Session createSession(Session session);
}
