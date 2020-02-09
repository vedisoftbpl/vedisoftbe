package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Session;

public interface ISessionService {
	Session createSession(Session session);
	List<Session> getAllSessions();
	Session getSessionById(Long id);
}
