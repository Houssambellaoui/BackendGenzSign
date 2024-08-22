package com.prod.GenZ.dao.DAOMySQL;

import com.prod.GenZ.model.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SignatureRepository extends JpaRepository<Signature, Integer> {
}