package com.cleanarquiteture.projectcore.infrastructure.persistence.configurations;

import com.cleanarquiteture.projectcore.domain.interfaces.repository.IApplicationUserRepository;
import com.cleanarquiteture.projectcore.domain.interfaces.services.IApplicationUserService;
import com.cleanarquiteture.projectcore.domain.services.ApplicationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {
    @Bean
    IApplicationUserService applicationUserService(IApplicationUserRepository applicationUserRepository){
        return new ApplicationUserService(applicationUserRepository);
    }
}
