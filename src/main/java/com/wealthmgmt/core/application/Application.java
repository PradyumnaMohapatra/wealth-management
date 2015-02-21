package com.wealthmgmt.core.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wealthmgmt.portfolio"})
@EntityScan(basePackages = {"com.wealthmgmt.portfolio.domain"})
@ImportResource(value = "classpath:axonContext.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
