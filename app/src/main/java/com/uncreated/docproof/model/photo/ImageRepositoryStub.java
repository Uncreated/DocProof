package com.uncreated.docproof.model.photo;

import android.graphics.Bitmap;

import io.reactivex.Completable;
import io.reactivex.Single;

public class ImageRepositoryStub implements ImageRepository {

    @Override
    public Completable addImage(Bitmap bitmap, String path) {
        return Completable.create(emitter -> {

        });
    }

    @Override
    public Single<Bitmap> getImage(String path) {
        return Single.create(emitter -> {

        });
    }

    @Override
    public Completable removeImage(String path) {
        return Completable.create(emitter -> {

        });
    }
}
