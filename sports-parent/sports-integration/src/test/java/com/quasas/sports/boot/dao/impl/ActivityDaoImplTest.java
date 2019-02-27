package com.quasas.sports.boot.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.quasas.sports.boot.dao.ActivityDao;
import com.quasas.sports.boot.entity.Activity;
import com.quasas.sports.boot.exception.SportsApplicationException;

//To load spring application context
//this is one of main integration tests principles
@ExtendWith(SpringExtension.class)
@SpringBootTest
//(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = {("spring.h2.console.enabled=true"),("spring.h2.console.path=/h2-console")})
class ActivityDaoImplTest {
	
	@Autowired
	ActivityDao activityDao;

	Activity activityObj = new Activity();
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		activityObj.setSourceId(Long.valueOf(2020253665));
		activityObj.setName("Integration Test add activity");
	}

	
	@Test
	@Transactional
	@Rollback(true)
	void testSave() throws SportsApplicationException {
		
		
		
		Activity result = activityDao.save(activityObj);
		
		assertNotNull(result);
		
		assertEquals(activityObj.getName(), result.getName());
		
	}

	@Disabled
	@Test
	@Transactional
	@Rollback(true)
	void testFindById() throws SportsApplicationException {
		
		Activity result = activityDao.findById((long) 1);
		
		assertNotNull(result);
		assertEquals(activityObj.getSourceId(), result.getSourceId());
		assertEquals(activityObj.getName(), result.getName());
		
		
	}

	@Disabled
	@Test
	@Transactional
	@Rollback(true)
	void testFindBySourceId() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	@Transactional
	@Rollback(true)
	void testFindAll() {
		fail("Not yet implemented");
	}

}
