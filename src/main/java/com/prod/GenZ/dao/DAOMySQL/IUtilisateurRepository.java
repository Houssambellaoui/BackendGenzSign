package com.prod.GenZ.dao.DAOMySQL;

import com.prod.GenZ.model.Role;
import com.prod.GenZ.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByLogin(String login);
    Optional<Utilisateur> findByNumcertif(String num_certif);
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);


    boolean existsByEmail(String login);
    boolean existsByIdIsNotAndEmail(Integer id, String password);


    Long countByRole(Role role);

//    boolean countAllBy(Integer id, String password);

    @Query("SELECT u.role, COUNT(u) FROM Utilisateur u GROUP BY u.role")
    List<Object[]> countUsersByRole();
}
