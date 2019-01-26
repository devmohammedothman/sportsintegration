package com.quasas.sports.boot.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quasas.sports.boot.exception.SportsApplicationException;
import com.quasas.sports.gen.client.model.DetailedActivity;
import com.quasas.sports.gen.client.model.SummaryActivity;


/**
 * This class provide basic common implementation for all service classes 
 * it is responsible for providing Mapping between Entity , Source API implementation logic
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 */
@Service
public class BasicServiceImpl<D, E> {

	// adding logging support
	protected static final Logger logger = LogManager.getLogger(BasicServiceImpl.class);

	protected static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	protected ModelMapper modelMapper;

	/**
	 * Convert from Entity to Client Api Model Object
	 * @param entity to be converted
	 * @param source client Api model Object
	 * @return Client api Model object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	@SuppressWarnings("unchecked")
	public D convertToAPISource(E entity, D source) throws SportsApplicationException {
		try {
			
			logger.info("Converting Entity with Source API :: Execution Time - {}  :: Source Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), source);

			//Perfom Mapping between Entity and Source APi Client
			D convertedDtoObj = (D) modelMapper.map(entity, source.getClass());

			// Log converted objects
			logger.info("Converting Entity with Source API Done :: Execution Time - {} ::  Converted Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), convertedDtoObj);

			return convertedDtoObj;
		} catch (Exception ex) {
			logger.error("Converting Entity with Source API Error :: Execution Time - {} :: Error Details {}",
					dateTimeFormatter.format(LocalDateTime.now()), ex.getMessage());

			//Throw Exception
			throw new SportsApplicationException("Mapping Exception :" + ex.getMessage());
		}
	}

	/**
	 * Convert from Client Api Model Object to Entity
	 * @param entity to be converted
	 * @param source client Api model Object
	 * @return Entity Object
	 * @throws SportsApplicationException Custom Application Exception
	 */
	@SuppressWarnings("unchecked")
	public E convertToEntity(E entity, D source) throws SportsApplicationException {
		try {

			// log source object to be converted
			logger.info("Converting Entity with Source API :: Execution Time - {}  :: Source Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), source);

			//Perfom Mapping between Entity and Source APi Client
			E convertedEntity = (E) modelMapper.map(source, entity.getClass());

			// Log converted objects
			logger.info("Converting Entity with Source API Done :: Execution Time - {}  :: Converted Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), convertedEntity);

			return convertedEntity;
		} catch (Exception ex) {
			logger.error("Converting Entity with Source API Error :: Execution Time - {} :: Error Details {}",
					dateTimeFormatter.format(LocalDateTime.now()), ex.getMessage());
			//throw Exception
			throw new SportsApplicationException("Mapping Exception :" + ex.getMessage());
		}
	}

	/**
	 * Convert between Client Source ApI model classes
	 * because there is different types for returned object from Client API
	 * @param sumActivity  Summary Activity Client API model
	 * @param dActivity Detailied Activity Client API model
	 * @return Summary Activity
	 * @throws SportsApplicationException Custom Application Exception
	 */
	public SummaryActivity convertFromDetailedToSummary(SummaryActivity sumActivity, DetailedActivity dActivity)
			throws SportsApplicationException {
		try {

			// log source object to be converted
			logger.info("Converting Entity with Source API :: Execution Time - {}  :: Source Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), dActivity);
			//Perform mapping
			SummaryActivity convertedEntity = (SummaryActivity) modelMapper.map(dActivity, SummaryActivity.class);

			//Log converted objects
			logger.info("Converting Entity with Source API Done :: Execution Time - {}  :: Converted Object :: {}",
					dateTimeFormatter.format(LocalDateTime.now()), convertedEntity);

			return convertedEntity;
		} catch (Exception ex) {
			logger.error("Converting Entity with Source API Error :: Execution Time - {} :: Error Details {}",
					dateTimeFormatter.format(LocalDateTime.now()), ex.getMessage());
			throw new SportsApplicationException("Mapping Exception :" + ex.getMessage());
		}
	}

	/**
	 * Used if there is special configuration needed from service classes to Mapping its Entity objects with Client API Objects
	 */
	protected void configureMapperLocally() {

	}

	protected boolean stringIsBlank(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
}
