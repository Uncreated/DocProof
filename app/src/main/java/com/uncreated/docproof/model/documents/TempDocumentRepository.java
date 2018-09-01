package com.uncreated.docproof.model.documents;

import android.graphics.Bitmap;

import com.uncreated.docproof.model.documents.entities.Page;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface TempDocumentRepository {

    Completable addPage(Bitmap bitmap);

    Observable<Page> createDocument();

    Completable saveDocument();

    Completable destroyDocument();
}
