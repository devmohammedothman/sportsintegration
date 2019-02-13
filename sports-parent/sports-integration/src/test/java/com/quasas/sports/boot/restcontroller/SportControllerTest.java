package com.quasas.sports.boot.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.boot.service.ActivityService;
import com.quasas.sports.boot.shared.ResponseDTO;
import com.quasas.sports.boot.shared.RestProvider;

class SportControllerTest {
	
	@Mock
	ActivityService activityService;
	
	//A field annotated with @Spy can be initialized explicitly at declaration point
	@Spy
	RestProvider restProvider;
	
	@InjectMocks
	SportController sportController;
	
	//Stub obect of activity
	Activity activityObj;
	
	//sample activity id 
	private Long activityId = Long.valueOf(2084377508);

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		//initialize retruned object from activity service
		activityObj = new Activity();
		activityObj.setSourceId(Long.valueOf(2084377508));
		activityObj.setName("Morning Run 01");
		activityObj.setDistance(5000f);
		activityObj.setMovingTime(5400);
	}

	@Test
	void testGetActivityById_success() throws SportsApplicationException {
		
		//return activity obj stub when service is called
		when(activityService.getActivityById(anyLong(), anyBoolean())).thenReturn(activityObj);
		
		ResponseEntity<ResponseDTO> result = sportController.getActivityById(activityId);
		
		Activity responseActivityObj = (Activity) result.getBody().getData();
		
		assertNotNull(result);
		
		assertNotNull(responseActivityObj);
		
		assertEquals(2001, result.getBody().getStatus().getCustomCode());
		
		assertEquals("Data Retreived Successfully", result.getBody().getStatus().getCustomMessage());
		
		assertEquals(activityId, responseActivityObj.getSourceId());
	}

	@Test
	void testGetAllActivities_success() throws SportsApplicationException {
		
		//prepare stub list of activity values
		List<Activity> stubActivityList = new ArrayList<Activity>();
		stubActivityList.add(activityObj);
		
		//define scenario when get all persistent activities called
		when(activityService.getAllPersistentActivities()).thenReturn(stubActivityList);
		
		ResponseEntity<ResponseDTO> result = sportController.getAllActivities();
		
		List<Activity> responseList = ((List<Activity>) result.getBody().getData());
		
		assertNotNull(result);
		
		assertNotNull(responseList);
		
		assertTrue(responseList.size() > 0);
		
		assertEquals(2001, result.getBody().getStatus().getCustomCode());
		
		assertEquals("Data Retreived Successfully", result.getBody().getStatus().getCustomMessage());
		
		assertEquals(activityId, responseList.get(0).getSourceId());
		
		
	}

}
