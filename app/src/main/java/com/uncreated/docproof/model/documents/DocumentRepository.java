package com.uncreated.docproof.model.documents;

import com.uncreated.docproof.model.documents.entities.Document;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface DocumentRepository {
    Completable addDocument(Document document);

    Observable<Document> getDocuments();

    Single<Document> getDocument(int index);

    Completable removeDocument(int index);
}
