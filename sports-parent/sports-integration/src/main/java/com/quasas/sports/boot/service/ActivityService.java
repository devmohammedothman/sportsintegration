package com.quasas.sports.boot.service;

import java.util.List;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

public interface ActivityService {

	
	public Activity getActivityById(Long id, Boolean includeAllEfforts) throws SportsApplicationException;
	
	public List<Activity> getLoggedInAthleteActivities() throws SportsApplicationException;
	
	public Activity save(Activity activityObj) throws SportsApplicationException;
	
	public List<Activity> getAllPersistentActivities() throws SportsApplicationException;
}
