package com.example.aopexamples.aopexample.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.example.aopexamples.aopexample.aspects.CommonPointcutConfig.dataPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method is called - {} is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.example.aopexamples.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - Method is called - {} has executed", joinPoint);
    }


    @AfterThrowing(pointcut = "com.example.aopexamples.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("After Throwing - {} has thrown exception {}", joinPoint, exception);
    }

    @AfterReturning(pointcut = "com.example.aopexamples.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()", returning = "resultValue")
    public void logMethodCallAfterSuccessExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("After Returning -  {} has returned {}", joinPoint, resultValue);
    }
}
