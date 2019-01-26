package com.quasas.sports.boot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.boot.service.ActivityService;
import com.quasas.sports.boot.shared.ResponseDTO;
import com.quasas.sports.boot.shared.RestProvider;
import com.quasas.sports.boot.shared.StatusCode;

/**
 * Restful Controller Class that define end points 
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */

@RestController
@RequestMapping("/api")
public class SportController {
	
	@Autowired
	private RestProvider restProvider;
	
	@Autowired
	private ActivityService activityService;
	
	/**
	 * This end point will get activity by id
	 * @param id source id of client api
	 * @return Customized Response DTO object that will has custom status message and actual data
	 * @throws SportsApplicationException Custom Application Exception
	 */
	@GetMapping(path="/activity/{id}" , produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> getActivityById(@PathVariable("id") Long id) throws SportsApplicationException 
	{
		//call activity service that wrap activity api method to return Activity entity 
		Activity resultActivityObj = activityService.getActivityById(id, Boolean.FALSE);
		
		//Define Custom Response DTO object with custom status Message and actual data
		ResponseDTO responseDto = null;
		if(resultActivityObj !=null)
			responseDto = new ResponseDTO(StatusCode.SUCCESSFULL, "Data Retreived Successfully",resultActivityObj );
		else
			responseDto = new ResponseDTO(StatusCode.NOTFOUND, "Bad Request", null);
		return restProvider.addObj(responseDto);
	}
	
	/**
	 * This end point will get all current activities in Data Base
	 * @return List of Activity Entity
	 * @throws SportsApplicationException Custom Application Exception
	 */
	@GetMapping(path = "/activity",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> getAllActivities() throws SportsApplicationException
	{
		List<Activity> resultList = activityService.getAllPersistentActivities();
		
		
		ResponseDTO responseDto = null;
		
		//Define Custom Response DTO object with custom status Message and actual data
		if(resultList !=null)
			responseDto = new ResponseDTO(StatusCode.SUCCESSFULL, "Data Retreived Successfully",resultList );
		else
			responseDto = new ResponseDTO(StatusCode.NOTFOUND, "Bad Request", null);
		return restProvider.addObj(responseDto);
	}

}
