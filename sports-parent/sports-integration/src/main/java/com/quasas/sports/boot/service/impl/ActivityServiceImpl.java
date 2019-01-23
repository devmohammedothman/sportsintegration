package com.quasas.sports.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.quasas.sports.boot.dao.ActivityDao;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.boot.service.ActivityService;
import com.quasas.sports.gen.client.api.ActivitiesApi;
import com.quasas.sports.gen.client.model.DetailedActivity;
import com.quasas.sports.gen.client.model.SummaryActivity;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivitiesApi activityApi;

	@Autowired
	private ActivityDao activityDao;

	@Override
	public DetailedActivity getActivityById(Long id, Boolean includeAllEfforts) throws SportsApplicationException {

		try {
			// get activity details from API
			DetailedActivity resultActivityObj = activityApi.getActivityById(id, includeAllEfforts);
			return resultActivityObj;
		} catch (RestClientException rsEx) {
			throw new SportsApplicationException(
					"Exception While Calling Service with Details >> " + rsEx.getMessage());
		} catch (Exception ex) {
			throw new SportsApplicationException("Exception While adding Activity to DataBase >> " + ex.getMessage());
		}

	}

	@Override
	public List<SummaryActivity> getLoggedInAthleteActivities() throws SportsApplicationException {

		try {
			// call get Logged In AthleteActivites from Client Api
			List<SummaryActivity> resultActivityList = activityApi.getLoggedInAthleteActivities(null,null,null,null);

			return resultActivityList;
		} catch (RestClientException ex) {
			throw new SportsApplicationException(
					"Rest Exception While Client Service to get Logged In Athlete Activities >> " + ex.getMessage());
		} catch (Exception ex) {
			throw new SportsApplicationException(
					"General Exception While Client Service to get Logged In Athlete Activities >> " + ex.getMessage());
		}

	}

	@Override
	public Activity save(Activity activityObj) throws SportsApplicationException {
		try {
			return activityDao.save(activityObj);
		} catch (Exception ex) {
			throw new SportsApplicationException(
					"General Exception While Adding Activity Object to Database >> " + ex.getMessage());
		}
	}

}
