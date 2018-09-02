package com.uncreated.docproof.model.documents;

import com.uncreated.docproof.model.documents.entities.Document;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import timber.log.Timber;

public class DocumentRepositoryStub implements DocumentRepository {

    private List<Document> documents = new ArrayList<>();

    public DocumentRepositoryStub() {
        Timber.d("DocumentRepositoryStub");
    }

    @Override
    public Single<Integer> addDocument(Document document) {
        return Single.create(emitter -> {
            documents.add(document);
            emitter.onSuccess(documents.size() - 1);
        });
    }

    @Override
    public Observable<Document> getDocuments() {
        return Observable.fromArray(documents.toArray(new Document[0]));
    }

    @Override
    public Single<Document> getDocument(int index) {
        return Single.create(emitter -> {
            emitter.onSuccess(documents.get(index));
        });
    }

    @Override
    public Completable removeDocument(int index) {
        return Completable.create(emitter -> {
            documents.remove(index);
            emitter.onComplete();
        });
    }
}
