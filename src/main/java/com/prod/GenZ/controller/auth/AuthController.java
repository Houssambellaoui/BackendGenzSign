package com.prod.GenZ.controller.auth;

import com.prod.GenZ.dao.DAOMySQL.MySqlFactory;
import com.prod.GenZ.model.Utilisateur;
import com.prod.GenZ.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/ncn/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @Autowired
    private MySqlFactory factory;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        System.out.println(request.getFirstName());
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authentificate")
    public ResponseEntity<Object> login(
            @RequestBody AuthentificationRequest request
    ){
        try {
            return ResponseEntity.ok(service.authentificate(request));
        } catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @PostMapping("/smartauthentificate")
    public ResponseEntity<Object> login2(
            @RequestBody AuthentificationRequest request
    ){
        try {
            return ResponseEntity.ok(service.authentificate2(request));
        } catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<AuthenticationResponse> logout(
            @RequestHeader (name="Authorization") String token
    ){
        try {
            service.logout(token.substring(7));
            System.out.println("###### logout success");
            return ResponseEntity.ok().build();
        } catch (Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> getUserBySmartcardSerialNumber(@RequestParam("numCertif") String numCertif) {
        Optional<Utilisateur> optionalUser = service.findUserBySmartcardSerialNumber(numCertif);
        if (optionalUser.isPresent()) {
            Utilisateur user = optionalUser.get();
            return ResponseEntity.ok(Map.of("login", user.getLogin(), "password", user.getPassword()));
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "User not found"));
        }
    }




//    @GetMapping("/test")
//    public List<Region> test(){
//        return factory.getRepRegions().findAll().stream().toList();
//    }
//
//    @GetMapping("/test1")
//    public List<Fonctionnaire> test1(){
//        return factory.getRepCommunes().findById(4).get().getFonctionnaires();
//    }
}
