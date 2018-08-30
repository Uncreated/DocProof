package com.uncreated.docproof.model.photo;

import android.graphics.Bitmap;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface ImageRepository {
    Completable addImage(Bitmap bitmap, String path);

    Single<Bitmap> getImage(String path);

    Completable removeImage(String path);
}
