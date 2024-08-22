package com.prod.GenZ.dao.DAOMySQL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter @NoArgsConstructor
public class MySqlFactory{


    @Autowired
    private IUtilisateurRepository          repUtilisateurs;
    @Autowired
    private DocumentRepository              repDocuments;
    @Autowired
    private SignatureRepository             repSignatures;

}
