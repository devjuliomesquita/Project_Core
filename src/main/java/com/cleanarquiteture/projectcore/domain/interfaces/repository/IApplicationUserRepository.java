package com.cleanarquiteture.projectcore.domain.interfaces.repository;

import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;

import java.util.List;
import java.util.UUID;

public interface IApplicationUserRepository {
    List<ApplicationUser> findAll();
    ApplicationUser findByName(String name);
    ApplicationUser findById(UUID id);
    void create(ApplicationUser applicationUser);
    void delete(UUID id);
}
