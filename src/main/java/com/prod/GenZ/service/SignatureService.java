package com.prod.GenZ.service;

import com.prod.GenZ.model.Signature;

import java.util.List;


public interface SignatureService {
    Signature saveSignature(Signature signature);
    Signature updateSignature(int id, Signature updatedSignature);
    void deleteSignature(int id);
    List<Signature> getAllSignatures();
    Signature getSignatureById(int id);
}
