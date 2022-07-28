package com.example.socialnetworkbe.service;


import com.example.socialnetworkbe.model.Role;

public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}
