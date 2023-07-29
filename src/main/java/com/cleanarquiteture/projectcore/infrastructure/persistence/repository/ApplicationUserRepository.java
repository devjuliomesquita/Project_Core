package com.cleanarquiteture.projectcore.infrastructure.persistence.repository;

import com.cleanarquiteture.projectcore.domain.interfaces.repository.IApplicationUserRepository;
import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;
import com.cleanarquiteture.projectcore.infrastructure.persistence.entities.ApplicationUserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ApplicationUserRepository implements IApplicationUserRepository {
    private final ISpringApplicationUserRepository repository;
    public ApplicationUserRepository(ISpringApplicationUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ApplicationUser> findAll() {
        List<ApplicationUserEntity> userEntities = repository.findAll();
        return userEntities.stream().map(ApplicationUserEntity::toApplicationUser).collect(Collectors.toList());
    }

    @Override
    public ApplicationUser findByName(String name) {
        Optional<ApplicationUserEntity> userEntity = this.repository.findByName(name);
        if (userEntity.isPresent()) {
            return userEntity.get().toApplicationUser();
        }
        throw new RuntimeException("User not found.");
    }

    @Override
    public ApplicationUser findById(UUID id) {
        Optional<ApplicationUserEntity> userEntity = repository.findById(id);
        if (userEntity.isPresent()) {
            return userEntity.get().toApplicationUser();
        }
        throw new RuntimeException("User not found.");
    }

    @Override
    public void create(ApplicationUser applicationUser) {
        try {
            if (Objects.isNull(applicationUser.getId())) {
                ApplicationUserEntity userEntity = new ApplicationUserEntity(applicationUser);
                repository.save(userEntity);
            }
        } catch (Exception e){
            new RuntimeException("User not create." + e);
        }
    }
    @Override
    public void update(ApplicationUser applicationUser) {
        try {
            ApplicationUserEntity userEntity = repository.findById(applicationUser.getId()).get();
            userEntity.update(applicationUser);
            repository.save(userEntity);
        } catch (Exception e) {
            new RuntimeException("User not found." + e);
        }
    }

    @Override
    public void delete(UUID id) {
        try{
            ApplicationUserEntity userEntity = repository.findById(id).get();
            repository.delete(userEntity);
        } catch (Exception e){
            new RuntimeException("User not found." + e);
        }

    }
}
