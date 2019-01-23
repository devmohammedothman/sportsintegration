package com.quasas.sports.boot.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quasas.sports.boot.dao.ActivityDao;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

@Repository
public class ActivityDaoImpl implements ActivityDao{

	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public Activity save(Activity activityObj) throws SportsApplicationException {
		
		try 
		{
			//save or update activity object
			Activity added_activityObj = entityManager.merge(activityObj);
			
			//update with id from db
			activityObj.setId(added_activityObj.getId());
			
			return added_activityObj;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new SportsApplicationException(ex.getMessage());
		}
	}

}
