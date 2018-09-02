package com.uncreated.docproof.model.documents;

import android.graphics.Bitmap;

import com.uncreated.docproof.model.documents.entities.Page;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface TempDocumentRepository {

    Completable addPage(Bitmap bitmap);

    Observable<Page> createDocument();

    Single<Integer> saveDocument();

    Completable deleteDocument();
}
