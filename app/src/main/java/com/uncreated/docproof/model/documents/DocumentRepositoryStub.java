package com.uncreated.docproof.model.documents;

import com.uncreated.docproof.model.documents.entities.Document;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class DocumentRepositoryStub implements DocumentRepository {

    private List<Document> documents = new ArrayList<>();

    public DocumentRepositoryStub() {
        for (int i = 1; i < 5; i++) {
            documents.add(Document.createTest(i));
        }
    }

    @Override
    public Completable addDocument(Document document) {
        return Completable.create(emitter -> {

        });
    }

    @Override
    public Observable<Document> getDocuments() {
        return Observable.fromArray(documents.toArray(new Document[0]));
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
