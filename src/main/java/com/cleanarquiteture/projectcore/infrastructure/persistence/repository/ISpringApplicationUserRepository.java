package com.cleanarquiteture.projectcore.infrastructure.persistence.repository;

import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;
import com.cleanarquiteture.projectcore.infrastructure.persistence.entities.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ISpringApplicationUserRepository extends JpaRepository<ApplicationUser, UUID> {
    Optional<ApplicationUserEntity> findbyName(String name);
}
