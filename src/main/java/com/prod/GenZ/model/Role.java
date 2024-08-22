package com.prod.GenZ.model;


import java.util.List;
import java.util.stream.Stream;


public enum Role {

    ADMINISTRATEUR("ADMINISTRATEUR"),
    RESPONSABLE("RESPONSABLE");


    Role(String role){
        this.role = role;
    }
    final String role;
    String getRole(){
        return role;
    }
    public static Role of(String role) {
        return Stream.of(Role.values())
                .filter(p -> p.getRole().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<Role> allRoles(){
        return Stream.of(Role.values()).toList();
    }
}
