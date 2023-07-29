package com.cleanarquiteture.projectcore.application;

import com.cleanarquiteture.projectcore.domain.dto.ApplicationUserDTO;
import com.cleanarquiteture.projectcore.domain.interfaces.services.IApplicationUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class ApplicationUserController {
    private final IApplicationUserService service;
    public ApplicationUserController(IApplicationUserService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<ApplicationUserDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public void create(@RequestBody ApplicationUserDTO applicationUserDTO){
        service.create(applicationUserDTO);
    }
}
