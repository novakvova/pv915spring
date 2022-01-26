package com.example.shop.web;

import com.example.shop.entities.RoleEntity;
import com.example.shop.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final RoleRepository roleRepository;

    @Autowired
    public HomeController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public List<RoleEntity> index() {
        return roleRepository.findAll();
    }
}
