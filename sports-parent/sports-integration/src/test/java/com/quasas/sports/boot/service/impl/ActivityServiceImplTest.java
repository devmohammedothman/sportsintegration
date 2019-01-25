package com.quasas.sports.boot.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.quasas.sports.boot.dao.ActivityDao;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.gen.client.api.ActivitiesApi;
import com.quasas.sports.gen.client.model.DetailedActivity;
import com.quasas.sports.gen.client.model.SummaryActivity;

class ActivityServiceImplTest {

	// Mocking activity dao object
	@Mock
	ActivityDao activityDao;

	// Mocking Activity API Client
	@Mock
	ActivitiesApi activityApi;

	@Mock
	ModelMapper modelMapper;

	@Mock
	SummaryActivity summaryActivityMock;

	// Inject Mocks for Activity Service Imp which is under Test
	@InjectMocks
	ActivityServiceImpl activityService;

	Long activitySourceId = Long.valueOf(2084377508);

	DetailedActivity resultActivityApi;

	SummaryActivity summaryActivity;

	Activity activityObj;

	@BeforeEach
	void setUp() throws Exception {
		// Allow Mockito to instantiate object of current class under test Activity
		// Service
		MockitoAnnotations.initMocks(this);

		// create Stub for DetaileActivity Object
		resultActivityApi = new DetailedActivity();
		resultActivityApi.setId(activitySourceId);
		resultActivityApi.setName("Morning Run 01");
		resultActivityApi.setDistance(5000.0f);
		resultActivityApi.setMovingTime(5400);
		resultActivityApi.setElapsedTime(5400);
		resultActivityApi.setTotalElevationGain(10f);
		resultActivityApi.setWorkoutType(3);

		resultActivityApi.setTimezone("(GMT-08:00) America/Los_Angeles");
		resultActivityApi.setAchievementCount(2);
		resultActivityApi.setCommentCount(2);
		resultActivityApi.setAthleteCount(1);
		resultActivityApi.setPhotoCount(4);
		resultActivityApi.setTrainer(Boolean.FALSE);
		resultActivityApi.setCommute(Boolean.FALSE);
		resultActivityApi.setManual(Boolean.TRUE);

		summaryActivity = new SummaryActivity();
		summaryActivity.setId(activitySourceId);
		summaryActivity.setName("Morning Run 01");
		summaryActivity.setDistance(5000.0f);
		summaryActivity.setMovingTime(5400);
		summaryActivity.setElapsedTime(5400);
		summaryActivity.setTotalElevationGain(10f);
		summaryActivity.setWorkoutType(3);

		summaryActivity.setTimezone("(GMT-08:00) America/Los_Angeles");
		summaryActivity.setAchievementCount(2);
		summaryActivity.setCommentCount(2);
		summaryActivity.setAthleteCount(1);
		summaryActivity.setPhotoCount(4);
		summaryActivity.setTrainer(Boolean.FALSE);
		summaryActivity.setCommute(Boolean.FALSE);
		summaryActivity.setManual(Boolean.TRUE);

		activityObj = new Activity();
		activityObj.setSourceId(Long.valueOf(2084377508));
		activityObj.setName("Morning Run 01");
		activityObj.setDistance(5000f);
		activityObj.setMovingTime(5400);

	}

	@Test
	final void testGetActivityById() throws SportsApplicationException {

		// Define Condition when calling Activity API Client to return stub Object
		when(activityApi.getActivityById(activitySourceId, Boolean.FALSE)).thenReturn(resultActivityApi);

		// when convert from detailed activity type to summary activity return stub
		// object of summary
		when(activityService.convertFromDetailedToSummary(summaryActivityMock, resultActivityApi))
				.thenReturn(summaryActivity);

		// when convert from summary activity to entity return stub Activity entity
		when(activityService.convertToEntity(activityObj, summaryActivity)).thenReturn(activityObj);

		// when find activity by source id return stub Activity entity
		when(activityDao.findBySourceId(activitySourceId)).thenReturn(activityObj);

		activityObj = activityService.getActivityById(activitySourceId, Boolean.FALSE);

		assertNotNull(activityObj);

		assertEquals(activityObj.getSourceId(), resultActivityApi.getId());

	}
	
	@Test
	final void testGetLoggedInAthleteActivities() throws SportsApplicationException
	{
		List<SummaryActivity> summaryActivityList = new ArrayList<>();
		summaryActivityList.add(summaryActivity);
		
		when(activityApi.getLoggedInAthleteActivities(null, null, null, null)).thenReturn(summaryActivityList);
		
		when(activityService.convertToEntity(activityObj, summaryActivity)).thenReturn(activityObj);
		
		List<Activity> activityResultList = new ArrayList<Activity>();
		activityResultList =  activityService.getLoggedInAthleteActivities();
		
		assertNotNull(activityResultList);
		
		assertTrue(activityResultList.size() > 0);
		
		assertEquals(activityObj.getSourceId(), activityResultList.get(0).getSourceId());
		
	}

}
