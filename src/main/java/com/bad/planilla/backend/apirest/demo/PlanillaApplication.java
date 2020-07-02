package com.bad.planilla.backend.apirest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@ComponentScan(basePackages={"com.bad.planilla.backend.apirest.services"})
@ComponentScan(basePackages={"com.bad.planilla.backend.apirest.restcontroller"})
@EnableJpaRepositories("com.bad.planilla.backend.apirest.repository")
@EntityScan("com.bad.planilla.backend.apirest.entity")
@ComponentScan("com.bad.planilla.backend.apirest.auth")
@EnableJpaAuditing
public class PlanillaApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("passwordEncoder")
	private BCryptPasswordEncoder passwordEncoder;
	
    public static void main(String[] args) {
        SpringApplication.run(PlanillaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		String passwordByCript = passwordEncoder.encode("12345");
		System.out.println(passwordByCript);
		
	}

}
