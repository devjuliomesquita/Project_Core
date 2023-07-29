package com.cleanarquiteture.projectcore;

import com.cleanarquiteture.projectcore.infrastructure.persistence.repository.ISpringApplicationUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ISpringApplicationUserRepository.class)
public class ProjectcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectcoreApplication.class, args);
	}

}
