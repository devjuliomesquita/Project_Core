package com.cleanarquiteture.projectcore.domain.services;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;
import com.cleanarquiteture.projectcore.domain.interfaces.repository.IApplicationUserRepository;
import com.cleanarquiteture.projectcore.domain.interfaces.services.IApplicationUserService;
import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ApplicationUserService implements IApplicationUserService {
    private final IApplicationUserRepository repository;
    public ApplicationUserService(IApplicationUserRepository repository){
        this.repository = repository;
    }
    @Override
    public List<ApplicationUserDTO> findAll() {
        List<ApplicationUser> users = repository.findAll();
        return users
                .stream()
                .map(ApplicationUser::applicationUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationUserDTO findByName(String name) {
        ApplicationUser user = repository.findByName(name);
        return user.applicationUserDTO();
    }

    @Override
    public ApplicationUserDTO findById(UUID id) {
        ApplicationUser user = repository.findById(id);
        return user.applicationUserDTO();
    }

    @Override
    public void create(ApplicationUserDTO applicationUserDTO) {
        ApplicationUser applicationUser = new ApplicationUser(applicationUserDTO);
        repository.create(applicationUser);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }
}
