package com.example.aopexamples.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;
//for common packages declerations
public class CommonPointcutConfig {

    @Pointcut("execution(* com.example.aopexamples.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {

    }

    @Pointcut("execution(* com.example.aopexamples.aopexample.business.*.*.*(..))")
    public void businessPackageConfig() {

    }

    @Pointcut("execution(* com.example.aopexamples.aopexample.data.*.*.*(..))")
    public void dataPackageConfig() {

    }

    @Pointcut("bean(*Service*)")
    public void dataPackageConfigUsingBean(){}


    @Pointcut("@annotation(com.example.aopexamples.aopexample.annotations.TrackTime)")
    public void tracTimeAnnotation(){}
}
