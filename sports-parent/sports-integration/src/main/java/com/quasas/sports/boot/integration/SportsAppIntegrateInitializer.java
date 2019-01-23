package com.quasas.sports.boot.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.quasas.sports.boot.config.AppLoggingAspect;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.boot.service.ActivityService;
import com.quasas.sports.gen.client.model.SummaryActivity;

@Component
public class SportsAppIntegrateInitializer {

	//adding logging support
	private static final Logger logger = LogManager.getLogger(AppLoggingAspect.class);
			
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Autowired
	ActivityService activityService;
	
	//10 mins = 100000 
	@Scheduled(fixedRate = 100000)
	public void scheduleCurrentAthleteActivities()
	{
		logger.info("Scheduled Task for Getting Current Athlete Activities Started :: Execution Time - {}", 
				dateTimeFormatter.format(LocalDateTime.now()) );
		
		
		try 
		{
			
			//Get List of Activities from API
			List<SummaryActivity> resultActivityList = activityService.getLoggedInAthleteActivities();
			
			
			//Loop over list of result activities to save in DB
			for(SummaryActivity item : resultActivityList)
			{
				Activity activityObj = new Activity();
				activityObj.setSourceId( item.getId());
				activityObj.setName( item.getName());
				activityService.save(activityObj);
			}
			
		} catch (SportsApplicationException e) {
			logger.error("Scheduled Task for Getting Current Athlete Activities Error :: Execution Time - {} :: Error Details {}", 
					dateTimeFormatter.format(LocalDateTime.now()),e.getMessage() );
		}

		logger.info("Scheduled Task for Getting Current Athlete Activities End :: Execution Time - {}", 
				dateTimeFormatter.format(LocalDateTime.now()) );
	}

}
