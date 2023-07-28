package com.cleanarquiteture.projectcore.domain.dto;

import java.util.UUID;

public class ApplicationUserDTO {
    private UUID id;
    private String name;
    public ApplicationUserDTO(UUID id, String name){
        this.id = id;
        this.name = name;
    }
    public UUID getId() {
        return id;
    }
    public String getName(){
        return name;
    }
}
