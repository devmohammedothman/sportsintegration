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

@RestController
@RequestMapping("/api")
public class SportController {
	
	@Autowired
	private RestProvider restProvider;
	
	@Autowired
	private ActivityService activityService;
	
	
	@GetMapping("/hello")
	public String helloController()
	{
		return "First Controller End point";
	}
	
	@GetMapping(path="/activity/{id}" , produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> getActivityById(@PathVariable("id") Long id) throws SportsApplicationException 
	{
		//call activity service that wrap activity api method to return Activity entity 
		Activity resultActivityObj = activityService.getActivityById(id, Boolean.FALSE);
						
		ResponseDTO responseDto = null;
		if(resultActivityObj !=null)
			responseDto = new ResponseDTO(StatusCode.SUCCESSFULL, "Data Retreived Successfully",resultActivityObj );
		else
			responseDto = new ResponseDTO(StatusCode.NOTFOUND, "Bad Request", null);
		return restProvider.addObj(responseDto);
	}
	
	@GetMapping(path = "/activity",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> getAllActivities() throws SportsApplicationException
	{
		List<Activity> resultList = activityService.getAllPersistentActivities();
		
		ResponseDTO responseDto = null;
		if(resultList !=null)
			responseDto = new ResponseDTO(StatusCode.SUCCESSFULL, "Data Retreived Successfully",resultList );
		else
			responseDto = new ResponseDTO(StatusCode.NOTFOUND, "Bad Request", null);
		return restProvider.addObj(responseDto);
	}

}
