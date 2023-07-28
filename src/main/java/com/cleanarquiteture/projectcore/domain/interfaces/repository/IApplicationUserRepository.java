package com.cleanarquiteture.projectcore.domain.interfaces.repository;

import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;

import java.util.List;

public interface IApplicationUserRepository {
    List<ApplicationUser> findAll();
    ApplicationUser findByName(String name);
    void create(ApplicationUser applicationUser);
}
