package com.cleanarquiteture.projectcore.application;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;
import com.cleanarquiteture.projectcore.domain.interfaces.services.IApplicationUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class ApplicationUserController {
    private final IApplicationUserService service;
    public ApplicationUserController(IApplicationUserService service){
        this.service = service;
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ApplicationUserDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<ApplicationUserDTO> getByName(@PathVariable("name") String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ApplicationUserDTO> getById(@PathVariable("id") UUID id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public void create(@RequestBody ApplicationUserDTO applicationUserDTO){
        service.create(applicationUserDTO);
    }
    @PutMapping
    public void update(@RequestBody ApplicationUserDTO applicationUserDTO){
        service.update(applicationUserDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") UUID id){
        service.delete(id);
    }
}
