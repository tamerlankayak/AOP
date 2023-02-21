package com.example.aopexamples;

import com.example.aopexamples.aopexample.business.BusinessService1;
import com.example.aopexamples.aopexample.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//running app's methods
@SpringBootApplication
public class AopExamplesApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private BusinessService1 businessService1;
    private BusinessService2 businessService2;

    public AopExamplesApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
        this.businessService1 = businessService1;
        this.businessService2 = businessService2;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopExamplesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("busiessservice1 returned is {}", businessService1.calculateMax());
        logger.info("busiessservice2 value returned is {}", businessService2.calculateMin());
    }
}
