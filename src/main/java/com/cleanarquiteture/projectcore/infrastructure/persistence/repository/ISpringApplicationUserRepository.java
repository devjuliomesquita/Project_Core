package com.cleanarquiteture.projectcore.infrastructure.persistence.repository;

import com.cleanarquiteture.projectcore.infrastructure.persistence.entities.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ISpringApplicationUserRepository extends JpaRepository<ApplicationUserEntity, UUID> {
    Optional<ApplicationUserEntity> findByName(String name);
}
