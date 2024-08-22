package com.prod.GenZ.service;

import com.prod.GenZ.dao.DAOMySQL.MySqlFactory;
import com.prod.GenZ.model.Role;
import com.prod.GenZ.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateursService {
    @Autowired
    private MySqlFactory repository;
    @Autowired
    private PasswordEncoder encoder;

    public Utilisateur getUserById(Integer id){
        return repository.getRepUtilisateurs().findById(id).orElse(null);
    }
    public List<Utilisateur> getAllUsers(){
        return repository.getRepUtilisateurs().findAll();
    }

    public Long getCountByRole(Role role){
        return repository.getRepUtilisateurs().countByRole(role);
    }

    public Utilisateur saveUser(Utilisateur user) {
        return repository.getRepUtilisateurs().save(user);
    }


    public void delete(int id){
        repository.getRepUtilisateurs().deleteById(id);
    }


    public Utilisateur updateUser(int id, Utilisateur user) {

        if (!repository.getRepUtilisateurs().existsById(id)) {
            return null;
        }

        user.setId(id);
        return repository.getRepUtilisateurs().save(user);


    }

}
