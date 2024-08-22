package com.prod.GenZ.controller;

import com.prod.GenZ.model.Role;
import com.prod.GenZ.model.Utilisateur;
import com.prod.GenZ.service.JwtService;
import com.prod.GenZ.service.UtilisateursService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController()
@RequestMapping("/api/ncn/utilisateurs")
public class UtilisateursController {

    @Autowired
    private UtilisateursService utilService;
    @Autowired
    private JwtService jwtService;



    @GetMapping("/getUserById/{id}")
    public Utilisateur getMesSignatures(
            @RequestHeader (name="Authorization") String token,
            @PathVariable(name = "id") Integer id
    ){
        try {
            // todo: only agents for the connected responsable
            return utilService.getUserById(id);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/getAllUsers")
    public List<Utilisateur> getUsers(
            @RequestHeader (name="Authorization") String token

    ){
        try {
            // todo: only agents for the connected responsable
            return utilService.getAllUsers();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/countAdmin")
    public Long getMesSignatures(
            @RequestHeader (name="Authorization") String token
//            @RequestBody Utilisateur user
    ){
        try {
            // todo: only agents for the connected responsable
            return utilService.getCountByRole(Role.ADMINISTRATEUR);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/update/id={id}")
    public String updateUser(@RequestHeader (name="Authorization") String token, @PathVariable("id") Integer id, @RequestBody Utilisateur utilisateur){
        utilService.updateUser(id, utilisateur);
        return "User Updated Successfully...";
    }

    @DeleteMapping("/delete/id={id}")
    public String deleteUser(@RequestHeader (name="Authorization") String token, @PathVariable("id") Integer id){
        utilService.delete(id);
        return "User Deleted Successfully...";
    }



}
