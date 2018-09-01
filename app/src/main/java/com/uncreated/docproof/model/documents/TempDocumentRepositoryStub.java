package com.uncreated.docproof.model.documents;

import android.graphics.Bitmap;

import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.model.documents.entities.Page;

import java.util.ArrayList;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class TempDocumentRepositoryStub implements TempDocumentRepository {

    private DocumentRepository documentRepository;

    private Document document;

    private Subject<Page> pageSubject;

    public TempDocumentRepositoryStub(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Completable addPage(Bitmap bitmap) {
        checkDocument();

        return Completable.create(emitter -> {
            Page page = Page.createTest();
            document.getPages().add(page);
            pageSubject.onNext(page);

            emitter.onComplete();
        });
    }

    private void checkDocument() {
        if (document == null)
            throw new RuntimeException("Call createDocument method before");
    }

    @Override
    public Observable<Page> createDocument() {
        if (document == null) {
            pageSubject = BehaviorSubject.create();

            document = new Document();
            document.setPages(new ArrayList<>());
        }

        return pageSubject;
    }

    @Override
    public Completable saveDocument() {
        checkDocument();

        Completable completable = documentRepository.addDocument(document);
        document = null;
        return completable;
    }

    @Override
    public Completable deleteDocument() {
        return Completable.create(emitter -> {
            document = null;
            emitter.onComplete();
        });
    }
}
