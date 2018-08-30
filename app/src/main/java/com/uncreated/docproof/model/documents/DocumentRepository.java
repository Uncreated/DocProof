package com.uncreated.docproof.model.documents;

import com.uncreated.docproof.model.documents.entities.Document;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface DocumentRepository {
    Observable<Document> getDocuments();

    Completable addDocument(Document document);

    Completable removeDocument(int index);
}
