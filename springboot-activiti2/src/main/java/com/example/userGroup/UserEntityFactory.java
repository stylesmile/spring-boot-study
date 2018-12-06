package com.example.userGroup;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author felixu
 * @Date 2018.08.14
 */
@Service
public class UserEntityFactory implements SessionFactory {

	@Autowired
	UserEntityManager actUserEntityService;

	@Override
	public Class<?> getSessionType() {
		return UserIdentityManager.class;
	}

	@Override
	public Session openSession() {
		return actUserEntityService;
	}

}
