package com.quasas.sports.boot.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {
	
	//adding logging support
		private static final Logger logger = LogManager.getLogger(AppLoggingAspect.class);
		
		
		@Pointcut("execution (* com.quasas.sports.boot.restcontroller.*.*(..))")
		private void forControllerLog()
		{}
		
		//declare point cut for service and dao packages
		@Pointcut("execution (* com.quasas.sports.boot.service.*.*(..))")
		private void forServicesLog()
		{}
		
		@Pointcut("execution (* com.quasas.sports.boot.dao.*.*(..))")
		private void forDaoLog()
		{}
		
		//merge all point cuts to one
		@Pointcut ("forControllerLog() || forServicesLog() || forDaoLog()")
		private void appLog() {}
		
		
		//before advice
		@Before("appLog()")
		public void beforeLogging(JoinPoint jpoint)
		{
			
			//display method signature
			String methodSig = jpoint.getSignature().toShortString();
			logger.info("=================>  @Action Method: "+methodSig);
			
			//display method params
			Object[] methodParams = jpoint.getArgs();
			for(Object temp : methodParams)
			{
				logger.info("=================> arguments: "+temp);
				
			}
			
		}
		
		@AfterThrowing(pointcut = "appLog()" , throwing = "error")
		public void afterThrowException(JoinPoint jpoint, Throwable error)
		{
			String methodSig = jpoint.getSignature().toShortString();
			logger.error("=================> @Exception at Method: " + methodSig );
			logger.error("=================> @Exception Details: " + error);
		}

}
