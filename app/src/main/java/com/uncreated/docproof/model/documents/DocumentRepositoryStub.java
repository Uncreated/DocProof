package com.uncreated.docproof.model.documents;

import com.uncreated.docproof.model.documents.entities.Document;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class DocumentRepositoryStub implements DocumentRepository {

    @Override
    public Completable addDocument(Document document) {
        return Completable.create(emitter -> {

        });
    }

    @Override
    public Observable<Document> getDocuments() {
        return Observable.create(emitter -> {

        });
    }

    @Override
    public Single<Document> getDocument(int index) {
        return Single.create(emitter -> {

        });
    }

    @Override
    public Completable removeDocument(int index) {
        return Completable.create(emitter -> {

        });
    }
}
