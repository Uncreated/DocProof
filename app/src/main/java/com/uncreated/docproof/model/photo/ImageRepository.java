package com.uncreated.docproof.model.photo;

import android.graphics.Bitmap;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface ImageRepository {
    Single<Bitmap> loadImage(String path);

    Completable saveImage(Bitmap bitmap, String path);

    Completable removeImage(String path);
}
