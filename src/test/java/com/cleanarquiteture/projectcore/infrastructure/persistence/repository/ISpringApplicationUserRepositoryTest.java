package com.cleanarquiteture.projectcore.infrastructure.persistence.repository;

import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;
import com.cleanarquiteture.projectcore.infrastructure.persistence.entities.ApplicationUserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Tests para o repository")
class ISpringApplicationUserRepositoryTest {
    @Autowired
    ISpringApplicationUserRepository applicationUserRepository;
    @Test
    @DisplayName("Test for saved User")
    void save_Persistence_User(){
        ApplicationUserEntity toBeSaved = createUser();
        ApplicationUserEntity userSaved = applicationUserRepository.save(toBeSaved);
        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getId()).isNotNull();
        Assertions.assertThat(userSaved.getName()).isEqualTo(toBeSaved.getName());
    }
    @Test
    @DisplayName("Test for update User")
    void update_Persistence_User(){

    }



    private ApplicationUserEntity createUser(){
        ApplicationUser user = new ApplicationUser(null, "Júlio");
        return new ApplicationUserEntity(user);
    }
}