package com.cleanarquiteture.projectcore.domain.dto;

public class ApplicationUserCreateDTO {
    private String name;
    public ApplicationUserCreateDTO(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
