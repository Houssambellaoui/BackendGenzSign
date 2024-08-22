package com.prod.GenZ.service;

import com.prod.GenZ.model.Document;

import java.util.List;

public interface DocumentService {
    Document saveDocument(Document document);
    Document updateDocument(int id, Document updatedDocument);
    void deleteDocument(int id);
    List<Document> getAllDocuments();
    Document getDocumentById(int id);
    public List<Object[]> getDocumentInfoWithSignatureCount();

}
