package com.prod.GenZ.controller;


import com.prod.GenZ.model.Signature;
import com.prod.GenZ.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ncn/Signature")
public class SignatureController {
    private final SignatureService signatureService;

    @Autowired
    public SignatureController(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSignature(  @RequestHeader (name="Authorization") String token,@RequestBody Signature signature) {
        System.out.println("##########  " + signature.getDocument());
        Signature addedSignature = signatureService.saveSignature(signature);
        if (addedSignature != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Signature added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add signature.");
        }
    }

    @GetMapping("/getAll")
    public List<Signature> getAllSignatures(  @RequestHeader (name="Authorization") String token) {
        return signatureService.getAllSignatures();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Signature> getSignatureById(  @RequestHeader (name="Authorization") String token, @PathVariable int id) {
        Signature signature = signatureService.getSignatureById(id);
        if (signature != null) {
            return ResponseEntity.status(HttpStatus.OK).body(signature);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<String> deleteSignature(  @RequestHeader (name="Authorization") String token, @PathVariable("id") int id) {
        Signature signature = signatureService.getSignatureById(id);
        if (signature != null) {
            signatureService.deleteSignature(id);
            return ResponseEntity.status(HttpStatus.OK).body("Signature deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Signature not found.");
        }
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<String> updateSignature(  @RequestHeader (name="Authorization") String token, @PathVariable("id") int id, @RequestBody Signature updatedSignature) {
        Signature existingSignature = signatureService.getSignatureById(id);
        if (existingSignature != null) {
            updatedSignature.setId_signature(id); // Set the correct ID
            Signature updated = signatureService.updateSignature(id, updatedSignature);
            if (updated != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Signature updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update signature.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Signature not found.");
        }
    }
}
