package com.quasas.sports.boot.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quasas.sports.boot.dao.ActivityDao;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

@Repository
public class ActivityDaoImpl implements ActivityDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Activity save(Activity activityObj) throws SportsApplicationException {

		try {
			
			// check if new activity parameter existing or not
			Activity foundActivity = findBySourceId(activityObj.getSourceId());
			
			// if it is exist it will be updated other wise will be inserted
			if (foundActivity != null)
				activityObj.setIdentifierKey(foundActivity.getIdentifierKey());
			
			// save or update activity object
			foundActivity = entityManager.merge(activityObj);

			return foundActivity;
		} catch (Exception ex) {
			throw new SportsApplicationException(ex.getMessage());
		}
	}

	@Override
	public Activity findById(int id) throws SportsApplicationException {

		try {

			// find activity by id
			Activity foundActivity = entityManager.find(Activity.class, id);

			// return activity object if found
			return foundActivity;
		} catch (Exception ex) {
			throw new SportsApplicationException(ex.getMessage());
		}
	}

	@Override
	public Activity findBySourceId(Long sourceId) throws SportsApplicationException {
		try {

			// create query object to find activity by Source Id which is id in the API it
			// self
			Query q = entityManager.createQuery("SELECT a from Activity a where a.sourceId=:sourceId");

			q.setParameter("sourceId", sourceId);

			// Get first result object from result set
			// it will be always one item in result because there is unique constraint on source id
			Activity foundActivity = (q.getResultList() != null && q.getResultList().size() > 0) ? (Activity) q.getResultList().get(0) : null;

			return foundActivity;
		}

		catch (Exception ex) {
			throw new SportsApplicationException(ex.getMessage());
		}
	}

}
