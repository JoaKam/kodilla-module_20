package com.kodilla.hibernate.manytomany.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.hibernate.manytomany.facade.api.SearchFacade.processSearchCompany(..))")
    public void logSearchCompany() {
        LOGGER.info("Searching Company.");
    }

    @Before("execution(* com.kodilla.hibernate.manytomany.facade.api.SearchFacade.processSearchEmployee(..))")
    public void logSearchEmployee() {
        LOGGER.info("Searching Employee.");
    }

    @Around("execution(* com.kodilla.hibernate.manytomany.facade.api.SearchFacade.processSearchEmployee(..))")
    public Object measureSearchEmployeeTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Searching employee proceeding time: " + (end - begin));
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @Around("execution(* com.kodilla.hibernate.manytomany.facade.api.SearchFacade.processSearchCompany(..))")
    public Object measureSearchCompanyTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Searchin company roceeding time: " + (end - begin));
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
