package com.prod.GenZ.dao.DAOMySQL;

import com.prod.GenZ.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    // JPQL query to return all document info and the number of signatures for each document


    @Query("SELECT d, COUNT(s) FROM Document d LEFT JOIN d.signatures s GROUP BY d")
    List<Object[]> getDocumentInfoWithSignatureCount();
}
