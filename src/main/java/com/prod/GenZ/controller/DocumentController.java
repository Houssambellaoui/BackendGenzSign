package com.prod.GenZ.controller;


import com.prod.GenZ.model.Document;
import com.prod.GenZ.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ncn/Documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addDocument(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody Document document) {

        Document addedDocument = documentService.saveDocument(document);

        if (addedDocument != null) {
            // Return the document ID as part of the response
            return ResponseEntity.status(HttpStatus.CREATED).body(addedDocument.getId_doc());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1); // You can choose an appropriate error code
        }
    }


    @GetMapping("/getAll")
    public List<Document> getAllDocuments(            @RequestHeader (name="Authorization") String token
                                                      ) {
        return documentService.getAllDocuments();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Document> getDocumentById(  @RequestHeader (name="Authorization") String token, @PathVariable int id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            return ResponseEntity.status(HttpStatus.OK).body(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<String> deleteDocument(  @RequestHeader (name="Authorization") String token, @PathVariable("id") int id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            documentService.deleteDocument(id);
            return ResponseEntity.status(HttpStatus.OK).body("Document deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found.");
        }
    }


    @PutMapping("/update/id={id}")
    public ResponseEntity<String> updateDocument(  @RequestHeader (name="Authorization") String token, @PathVariable("id") int id, @RequestBody Document updatedDocument) {
        Document existingDocument = documentService.getDocumentById(id);
        if (existingDocument != null) {
            Document updated = documentService.updateDocument(id, updatedDocument);
            if (updated != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Document updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update document.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found.");
        }
    }
    @GetMapping("/infoWithSignatureCount")
    public List<Object[]> getDocumentInfoWithSignatureCount() {
        return documentService.getDocumentInfoWithSignatureCount();
    }
}
