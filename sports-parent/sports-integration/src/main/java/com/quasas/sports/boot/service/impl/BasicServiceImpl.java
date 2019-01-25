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

@Service
public class BasicServiceImpl<D, E> {

	// adding logging support
	protected static final Logger logger = LogManager.getLogger(BasicServiceImpl.class);

	protected static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	protected ModelMapper modelMapper;

	@SuppressWarnings("unchecked")
	public D convertToAPISource(E entity, D source) throws SportsApplicationException {
		try {
			
			logger.info("Converting Entity with Source API :: Execution Time - {}  :: Source Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), source);

			D convertedDtoObj = (D) modelMapper.map(entity, source.getClass());

			// Log converted objects
			logger.info("Converting Entity with Source API Done :: Execution Time - {} ::  Converted Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), convertedDtoObj);

			return convertedDtoObj;
		} catch (Exception ex) {
			logger.error("Converting Entity with Source API Error :: Execution Time - {} :: Error Details {}",
					dateTimeFormatter.format(LocalDateTime.now()), ex.getMessage());

			throw new SportsApplicationException("Mapping Exception :" + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public E convertToEntity(E entity, D source) throws SportsApplicationException {
		try {

			// log source object to be converted
			logger.info("Converting Entity with Source API :: Execution Time - {}  :: Source Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), source);

			E convertedEntity = (E) modelMapper.map(source, entity.getClass());

			// Log converted objects
			logger.info("Converting Entity with Source API Done :: Execution Time - {}  :: Converted Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), convertedEntity);

			return convertedEntity;
		} catch (Exception ex) {
			logger.error("Converting Entity with Source API Error :: Execution Time - {} :: Error Details {}",
					dateTimeFormatter.format(LocalDateTime.now()), ex.getMessage());
			throw new SportsApplicationException("Mapping Exception :" + ex.getMessage());
		}
	}

	public SummaryActivity convertFromDetailedToSummary(SummaryActivity sumActivity, DetailedActivity dActivity)
			throws SportsApplicationException {
		try {

			// log source object to be converted
			logger.info("Converting Entity with Source API :: Execution Time - {}  :: Source Object - {}",
					dateTimeFormatter.format(LocalDateTime.now()), dActivity);

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

	protected void configureMapperLocally() {

	}

	protected boolean stringIsBlank(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
}
