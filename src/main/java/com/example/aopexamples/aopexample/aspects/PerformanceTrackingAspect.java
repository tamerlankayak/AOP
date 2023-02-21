package com.example.aopexamples.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    Logger logger = LoggerFactory.getLogger(getClass());


    //@Around("com.example.aopexamples.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Around("com.example.aopexamples.aopexample.aspects.CommonPointcutConfig.tracTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in ms - {}", proceedingJoinPoint, executionDuration);

        return returnValue;
    }


}
