package com.bad.planilla.backend.apirest.demo;

import com.jfilter.EnableJsonFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.bad.planilla.backend.apirest.services"})
@ComponentScan(basePackages={"com.bad.planilla.backend.apirest.restcontroller"})
@EnableJpaRepositories("com.bad.planilla.backend.apirest.repository")
@EntityScan("com.bad.planilla.backend.apirest.entity")
public class PlanillaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanillaApplication.class, args);
    }

}
