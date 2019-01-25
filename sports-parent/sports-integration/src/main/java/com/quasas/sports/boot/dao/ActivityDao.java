package com.quasas.sports.boot.dao;

import java.util.List;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

public interface ActivityDao {
	
	public Activity save(Activity activityObj) throws SportsApplicationException;
	
	public Activity findById(int id) throws SportsApplicationException;
	
	public Activity findBySourceId(Long sourceId) throws SportsApplicationException;
	
	public List<Activity> findAll() throws SportsApplicationException;

}
