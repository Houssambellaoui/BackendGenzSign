package com.prod.GenZ.service;


import com.prod.GenZ.dao.DAOMySQL.DocumentRepository;
import com.prod.GenZ.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{


    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(int id, Document updatedDocument) {
        Optional<Document> existingDocument = documentRepository.findById(id);
        if (existingDocument.isPresent()) {
            updatedDocument.setId_doc(id); // Set the correct ID
            return documentRepository.save(updatedDocument);
        }
        return null; // Handle the case where the document with the given ID is not found
    }

    @Override
    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(int id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.orElse(null); // Return null if the document with the given ID is not found
    }
    @Override
    public List<Object[]> getDocumentInfoWithSignatureCount() {
        return documentRepository.getDocumentInfoWithSignatureCount();
    }

}
