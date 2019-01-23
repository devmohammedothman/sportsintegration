package com.quasas.sports.boot.dao;

import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

public interface ActivityDao {
	
	public Activity save(Activity activityObj) throws SportsApplicationException;

}
