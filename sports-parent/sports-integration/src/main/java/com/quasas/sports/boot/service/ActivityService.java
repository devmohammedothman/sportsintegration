package com.quasas.sports.boot.service;

import java.util.List;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

/**
 * Service Interface that will provide basic Client API operations with Needed DAO methods
 * it act as business layer over DAO and Client API methods , it responsible for orchestrate between DAO,Client API 
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */
public interface ActivityService {


	/**
	 * Get Activity by its source id in Client api . it is firstly call Client API to get Activity object
	 * and check if not exist in Database then call Save from DAO to insert it into DB or just update it.
	 * it is responsible for mapping logic between returned Activity from Client API and Activity Entity saved in DB
	 * @param id Source Id of Activity in Strava Client API
	 * @param includeAllEfforts boolean value to include all efforts
	 * @return Activity entity Object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public Activity getActivityById(Long id, Boolean includeAllEfforts) throws SportsApplicationException;
	
	/**
	 * Get Current Logged in Athlete Activities, it calls Client API to get list of client Activity objects
	 * Then Map this list to Activity Entity 
	 * @return List of Entity Activity
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public List<Activity> getLoggedInAthleteActivities() throws SportsApplicationException;
	
	/**
	 * Save New Activity or Update Existing Activity Object
	 * @param activityObj Activity Object to be saved or updated
	 * @return saved or updated activity Object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public Activity save(Activity activityObj) throws SportsApplicationException;
	
	/**
	 * Get All current activities in Database
	 * @return List of Activities 
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public List<Activity> getAllPersistentActivities() throws SportsApplicationException;
}
