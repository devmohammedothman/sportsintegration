package com.quasas.sports.boot.dao;

import java.util.List;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

/**
 * Activity DAO Interface that support basic CRUD Operation on Database
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */
public interface ActivityDao {
	
	/**
	 * Save New Activity or Update Existing Activity Object
	 * @param activityObj Activity Object to be saved or updated
	 * @return saved or updated activity Object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public Activity save(Activity activityObj) throws SportsApplicationException;
	
	/**
	 * Find Activity by Primary key column 
	 * @param id primary key value in Database
	 * @return Found Activity Object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public Activity findById(Long id) throws SportsApplicationException;
	
	/**
	 * Find Activity in Database by Source id which is Id of Activity at Strava Client API
	 * @param sourceId client API ID
	 * @return Found Activity Object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public Activity findBySourceId(Long sourceId) throws SportsApplicationException;
	
	
	/**
	 * Get All current activities in Database
	 * @return List of Activities 
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public List<Activity> findAll() throws SportsApplicationException;

}
