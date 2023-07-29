package com.cleanarquiteture.projectcore.domain.services;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;
import com.cleanarquiteture.projectcore.domain.interfaces.repository.IApplicationUserRepository;
import com.cleanarquiteture.projectcore.domain.interfaces.services.IApplicationUserService;
import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;

import java.util.List;
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
    public void create(ApplicationUserDTO applicationUserDTO) {
        ApplicationUser applicationUser = new ApplicationUser(applicationUserDTO);
        repository.create(applicationUser);
    }
}
