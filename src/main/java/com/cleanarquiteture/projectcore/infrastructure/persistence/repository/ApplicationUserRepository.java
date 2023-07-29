package com.cleanarquiteture.projectcore.infrastructure.persistence.repository;

import com.cleanarquiteture.projectcore.domain.interfaces.repository.IApplicationUserRepository;
import com.cleanarquiteture.projectcore.domain.model.ApplicationUser;
import com.cleanarquiteture.projectcore.infrastructure.persistence.entities.ApplicationUserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ApplicationUserRepository implements IApplicationUserRepository {
    private final ISpringApplicationUserRepository repository;
    public ApplicationUserRepository(ISpringApplicationUserRepository repository){
        this.repository = repository;
    }
    @Override
    public List<ApplicationUser> findAll() {
        List<ApplicationUserEntity> userEntities = repository.findAll();
        return userEntities.stream().map(ApplicationUserEntity::toApplicationUser).collect(Collectors.toList());
    }

    @Override
    public ApplicationUser findByName(String name) {
        Optional<ApplicationUserEntity> userEntity = this.repository.findbyName(name);
        if(userEntity.isPresent()){
            return userEntity.get().toApplicationUser();
        }
        throw new RuntimeException("User not found.");
    }

    @Override
    public void create(ApplicationUser applicationUser) {
        ApplicationUserEntity userEntity;
        if (Objects.isNull(applicationUser.getId())){
            userEntity = new ApplicationUserEntity(applicationUser);
        }else {
            userEntity = repository.findById(applicationUser.getId()).get();
            userEntity.update(applicationUser);
        }
        repository.save(userEntity);
    }
}
