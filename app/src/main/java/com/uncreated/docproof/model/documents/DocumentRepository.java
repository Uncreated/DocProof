package com.uncreated.docproof.model.documents;

import com.uncreated.docproof.model.documents.entities.Document;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface DocumentRepository {
    Completable addDocument(Document document);

    Observable<Document> getDocuments();

    Completable removeDocument(int index);
}
