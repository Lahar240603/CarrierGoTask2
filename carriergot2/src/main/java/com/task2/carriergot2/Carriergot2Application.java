package com.task2.carriergot2;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Carriergot2Application {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public AuditReader auditReader() {
		return AuditReaderFactory.get(entityManagerFactory.createEntityManager());
	}
	public static void main(String[] args) {
		SpringApplication.run(Carriergot2Application.class, args);
	}

}