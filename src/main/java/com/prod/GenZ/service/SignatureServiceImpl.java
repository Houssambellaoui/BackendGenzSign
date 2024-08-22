package com.prod.GenZ.service;


import com.prod.GenZ.dao.DAOMySQL.SignatureRepository;
import com.prod.GenZ.model.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SignatureServiceImpl implements SignatureService{


    private final SignatureRepository signatureRepository ;

    @Autowired
    public SignatureServiceImpl(SignatureRepository signatureRepository) {
        this.signatureRepository = signatureRepository;
    }

    @Override
    public Signature saveSignature(Signature signature) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        signature.setDate_signature(date);
        return signatureRepository.save(signature);
    }

    @Override
    public Signature updateSignature(int id, Signature updatedSignature) {
        Optional<Signature> existingSignature = signatureRepository.findById(id);
        if (existingSignature.isPresent()) {
            updatedSignature.setId_signature(id); // Set the correct ID
            return signatureRepository.save(updatedSignature);
        }
        return null; // Handle the case where the signature with the given ID is not found
    }

    @Override
    public void deleteSignature(int id) {
        signatureRepository.deleteById(id);
    }

    @Override
    public List<Signature> getAllSignatures() {
        return signatureRepository.findAll();
    }

    @Override
    public Signature getSignatureById(int id) {
        Optional<Signature> signature = signatureRepository.findById(id);
        return signature.orElse(null); // Return null if the signature with the given ID is not found
    }
}
