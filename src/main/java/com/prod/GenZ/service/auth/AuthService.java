package com.prod.GenZ.service.auth;

import com.prod.GenZ.controller.auth.AuthenticationResponse;
import com.prod.GenZ.controller.auth.AuthentificationRequest;
import com.prod.GenZ.controller.auth.RegisterRequest;
import com.prod.GenZ.dao.DAOMySQL.MySqlFactory;
import com.prod.GenZ.model.Role;
import com.prod.GenZ.model.Utilisateur;
import com.prod.GenZ.model.exceptions.CredentialsLoginException;
import com.prod.GenZ.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private MySqlFactory repository;
//    private final IUtilisateurRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Utilisateur.builder()
                .nom(request.getLastName())
                .prenom(request.getFirstName())
                .login(request.getLogin())
                .password(encoder.encode(request.getPassword()))
                .numcertif(request.getNumcertif())
                .role(Role.ADMINISTRATEUR)
                .build();

//        System.out.println(user);
        repository.getRepUtilisateurs().save(user);

        var jswToken = jwtService.generateToken(user, 24);
        return AuthenticationResponse
                .builder()
                .token(jswToken)
                .build();
//        return null;
    }

    public AuthenticationResponse authentificate(AuthentificationRequest request) throws Exception {
//        try {
            System.out.println("####### Trying login #######");
            //System.out.println(request.getLogin() + " - " + request.getPassword());
            //System.out.println(encoder.encode(request.getPassword()));

//            var user1 = repository.getRepUtilisateurs().findByLogin(request.getLogin())
//                    .orElseThrow();

//            System.out.println("###### check password : " + encoder.matches(request.getPassword(), user1.getPassword()));

            try{
                System.out.println("password test"+ request.getPassword());
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getLogin(),
                                request.getPassword()
                                )
                );
            } catch (BadCredentialsException e) {
                throw new CredentialsLoginException();
            }

            var user = repository.getRepUtilisateurs().findByLogin(request.getLogin())
                        .orElseThrow();

            Map<String, Object > vals = new HashMap<>();
            vals.put("login", user.getLogin());
            vals.put("id", user.getId());
            vals.put("role", user.getRole());
            vals.put("nom", user.getNom());
            vals.put("prenom", user.getPrenom());
            vals.put("numcertif", user.getNumcertif());

//            if(RolesUtils.isIn(List.of(Role.RESPONSABLE, Role.AGENT_ADMINISTRATIF), user.getRole())){
//                //System.out.println("## Is in the list of roles.....");
//                var fonct = repository.getRepFonctionnaies().findById(user.getId())
//                        .orElseThrow();
//                vals.put("commune", fonct.getCommuneTravail().getId());
//            } else if(RolesUtils.isIn(List.of(Role.CITOYEN), user.getRole())){
//                //System.out.println("## Is in the list of roles.....");
//                var citoyen = repository.getRepCitoyens().findById(user.getId())
//                        .orElseThrow();
//                vals.put("commune", citoyen.getCommuneResidence().getId());
//            }
            vals.values().forEach(System.out::println);
            var jswToken = jwtService.generateToken( vals ,user, 24);
                return AuthenticationResponse
                        .builder()
                        .token(jswToken)
                        .build();

//        } catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }

    }


    //auth with smartcard
    public AuthenticationResponse authentificate2(AuthentificationRequest request) throws Exception {
//        try {
        System.out.println("####### Trying login #######");
        //System.out.println(request.getLogin() + " - " + request.getPassword());
        //System.out.println(encoder.encode(request.getPassword()));

//            var user1 = repository.getRepUtilisateurs().findByLogin(request.getLogin())
//                    .orElseThrow();

//            System.out.println("###### check password : " + encoder.matches(request.getPassword(), user1.getPassword()));



        var user = repository.getRepUtilisateurs().findByLogin(request.getLogin())
                .orElseThrow();
        if (!request.getPassword().equals(user.getPassword())) {
            throw new CredentialsLoginException();
        }

        Map<String, Object > vals = new HashMap<>();
        vals.put("login", user.getLogin());
        vals.put("id", user.getId());
        vals.put("role", user.getRole());
        vals.put("nom", user.getNom());
        vals.put("prenom", user.getPrenom());
        vals.put("numcertif", user.getNumcertif());

//            if(RolesUtils.isIn(List.of(Role.RESPONSABLE, Role.AGENT_ADMINISTRATIF), user.getRole())){
//                //System.out.println("## Is in the list of roles.....");
//                var fonct = repository.getRepFonctionnaies().findById(user.getId())
//                        .orElseThrow();
//                vals.put("commune", fonct.getCommuneTravail().getId());
//            } else if(RolesUtils.isIn(List.of(Role.CITOYEN), user.getRole())){
//                //System.out.println("## Is in the list of roles.....");
//                var citoyen = repository.getRepCitoyens().findById(user.getId())
//                        .orElseThrow();
//                vals.put("commune", citoyen.getCommuneResidence().getId());
//            }
        vals.values().forEach(System.out::println);
        var jswToken = jwtService.generateToken( vals ,user, 24);
        return AuthenticationResponse
                .builder()
                .token(jswToken)
                .build();

//        } catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }

    }

    public void logout(String token) throws Exception{
        try{
            jwtService.blacklistToken(token);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Optional<Utilisateur> findUserBySmartcardSerialNumber(String numCertif) {
        return Optional.ofNullable(repository.getRepUtilisateurs().findByNumcertif(numCertif)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
