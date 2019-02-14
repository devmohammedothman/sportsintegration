package com.quasas.sports.boot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quasas.sports.boot.dao.ActivityDao;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

/**
 * Activity DAO Implementation that support basic CRUD Operation on Database
 * Use Spring JPA entity Manager for database Operations
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */

@Repository
public class ActivityDaoImpl implements ActivityDao {

	@Autowired
	private EntityManager entityManager;

	/**
	 * Save New Activity or Update Existing Activity Object
	 */
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

	/**
	 * Find Activity by Primary key column
	 */
	@Override
	public Activity findById(Long id) throws SportsApplicationException {

		try {

			// find activity by id
			Activity foundActivity = entityManager.find(Activity.class, id);

			// return activity object if found
			return foundActivity;
		} catch (Exception ex) {
			throw new SportsApplicationException(ex.getMessage());
		}
	}

	/**
	 * Find Activity in Database by Source id which is Id of Activity at Strava Client API
	 */
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

	/**
	 * Get All current activities in Database
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findAll() throws SportsApplicationException {
		try {
			//define returned result List
			List<Activity> resultList ;
			
			//Create Query
			Query q = entityManager.createQuery("From Activity");
			
			//execute query and get result list
			resultList = q.getResultList();
			
			return resultList;
		}
		catch (Exception ex) {
			throw new SportsApplicationException(ex.getMessage());
		}
	}

}
