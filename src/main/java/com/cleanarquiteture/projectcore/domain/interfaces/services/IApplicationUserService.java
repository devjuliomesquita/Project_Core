package com.cleanarquiteture.projectcore.domain.interfaces.services;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;

import java.util.List;

public interface IApplicationUserService {
    List<ApplicationUserDTO> findAll();
    void create(ApplicationUserDTO applicationUserDTO);
}
