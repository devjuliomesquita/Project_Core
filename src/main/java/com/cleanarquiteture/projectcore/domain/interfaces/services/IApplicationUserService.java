package com.cleanarquiteture.projectcore.domain.interfaces.services;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;

import java.util.List;
import java.util.UUID;

public interface IApplicationUserService {
    List<ApplicationUserDTO> findAll();
    ApplicationUserDTO findByName(String name);
    ApplicationUserDTO findById(UUID id);
    void create(ApplicationUserDTO applicationUserDTO);
    void delete(UUID id);
}
