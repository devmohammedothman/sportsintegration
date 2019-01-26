package com.quasas.sports.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.PropertyMap;
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
public class ActivityServiceImpl extends BasicServiceImpl<SummaryActivity, Activity> implements ActivityService {

	@Autowired
	private ActivitiesApi activityApi;

	@Autowired
	private ActivityDao activityDao;

	@PostConstruct
	public void init() {
		configureMapperLocally();
	}

	@Override
	public Activity getActivityById(Long id, Boolean includeAllEfforts) throws SportsApplicationException {

		try {
			// get activity details from API
			DetailedActivity detailedActivityObj = activityApi.getActivityById(id, includeAllEfforts);

			// convert from Detailed Activity to Summary Activity
			SummaryActivity convertedSummaryActivity = new SummaryActivity();
			convertedSummaryActivity = convertFromDetailedToSummary(convertedSummaryActivity, detailedActivityObj);

			// then convert Summary activity to Entity Activity
			Activity resultActivityObj = new Activity();
			resultActivityObj = convertToEntity(resultActivityObj, convertedSummaryActivity);

			// check if resultActivity exist in DB else will be saved firstly
			Activity foundActivityObj = activityDao.findBySourceId(resultActivityObj.getSourceId());

			if (foundActivityObj == null)
				activityDao.save(resultActivityObj);

			resultActivityObj.setIdentifierKey(foundActivityObj.getIdentifierKey());

			return resultActivityObj;
		} catch (RestClientException rsEx) {
			throw new SportsApplicationException(
					"Exception While Calling Service with Details >> " + rsEx.getMessage());
		} catch (Exception ex) {
			throw new SportsApplicationException("Exception While adding Activity to DataBase >> " + ex.getMessage());
		}

	}

	@Override
	public List<Activity> getLoggedInAthleteActivities() throws SportsApplicationException {

		try {

			// call get Logged In AthleteActivites from Client Api
			List<SummaryActivity> sourceActivityList = activityApi.getLoggedInAthleteActivities(null, null, null, null);

			// Define result Activity List
			List<Activity> resultActivityList = new ArrayList<Activity>();
			// convert API source Activity Object to Entity Activity
			if (sourceActivityList != null && sourceActivityList.size() > 0) {
				for (SummaryActivity item : sourceActivityList) {
					Activity convertedActivity = new Activity();
					convertedActivity = convertToEntity(convertedActivity, item);

					// add converted Activity object to result activity list
					resultActivityList.add(convertedActivity);
				}
			}

			return resultActivityList;

		} catch (RestClientException ex) {
			throw new SportsApplicationException(
					"Rest Exception While Calling Service to get Logged In Athlete Activities >> " + ex.getMessage());
		} catch (Exception ex) {
			throw new SportsApplicationException(
					"General Exception While Calling Service to get Logged In Athlete Activities >> "
							+ ex.getMessage());
		}

	}

	@Override
	public Activity save(Activity activityObj) throws SportsApplicationException {
		try {
			//call save method from DAO to save or update activity
			return activityDao.save(activityObj);
		} catch (Exception ex) {
			throw new SportsApplicationException(
					"General Exception While Adding Activity Object to Database >> " + ex.getMessage());
		}
	}

	protected void configureMapperLocally() {
		modelMapper.addMappings(new PropertyMap<SummaryActivity, Activity>() {
			protected void configure() {
				map().setSourceId(source.getId());
				map().setAthlete(source.getAthlete().getId());
			}
		});
	}

	@Override
	public List<Activity> getAllPersistentActivities() throws SportsApplicationException {
		try {
			//find all activities in DB
			return activityDao.findAll();
		} catch (Exception ex) {
			throw new SportsApplicationException(
					"General Exception While Get All Activity List From Database >> " + ex.getMessage());
		}
	}

}
