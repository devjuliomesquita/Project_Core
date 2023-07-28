package com.cleanarquiteture.projectcore.domain.model;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;

import java.util.UUID;

public class ApplicationUser {
    private UUID id;
    private String name;
    public ApplicationUser(){}
    public ApplicationUser(UUID id, String name){
        this.id = id;
        this.name = name;
    }
    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public ApplicationUser(ApplicationUserDTO applicationUserDTO){
        this.id = applicationUserDTO.getId();
        this.name = applicationUserDTO.getName();
    }
    public ApplicationUserDTO applicationUserDTO(){
        return new ApplicationUserDTO(this.id, this.name);
    }
}
