package com.cleanarquiteture.projectcore.infrastructure.persistence.entities;

import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class ApplicationUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    public UUID getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public ApplicationUserEntity(){}
    public ApplicationUserEntity(ApplicationUser applicationUser){
        this.name = applicationUser.getName();
    }
    public void update(ApplicationUser applicationUser){
        this.id = applicationUser.getId();
        this.name = applicationUser.getName();
    }
    public ApplicationUser toApplicationUser(){
        return new ApplicationUser(this.id, this.name);
    }
}
