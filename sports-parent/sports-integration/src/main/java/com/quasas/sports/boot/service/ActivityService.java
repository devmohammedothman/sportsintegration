package com.quasas.sports.boot.service;

import java.util.List;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.gen.client.model.DetailedActivity;
import com.quasas.sports.gen.client.model.SummaryActivity;

public interface ActivityService {

	
	public DetailedActivity getActivityById(Long id, Boolean includeAllEfforts) throws SportsApplicationException;
	
	public List<SummaryActivity> getLoggedInAthleteActivities() throws SportsApplicationException;
	
	public Activity save(Activity activityObj) throws SportsApplicationException;
}
