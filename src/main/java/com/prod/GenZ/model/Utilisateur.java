package com.prod.GenZ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Utilisateur implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer         id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected Role            role;
    @Column(nullable = false, unique = true)
    protected String          login;
//    @Column(nullable = false)
    @JsonIgnore
    protected String          password;

    @Column(nullable = false)
    protected String          nom;

    @Column(nullable = false)
    protected String          prenom;


    protected String          email;

    protected String          photo;
    protected String          numcertif;

    public String getNumcertif() {
        return numcertif;
    }

    public void setNum_certif(String num_certif) {
        this.numcertif = num_certif;
    }

    public void setPassword(String password){
        if(password == null || password.isEmpty() || password.isBlank()){
            System.out.println("### Generated password ###");
//            this.password = MyRandoms.generateRandomPassword(8);
            this.password = "123456";
        } else {
            System.out.println("### Right password ###");
            this.password = password;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRole()));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
//        return etatCompte.equals(EtatCompte.ACTIF);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
