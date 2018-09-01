package com.uncreated.docproof.ui.fragments.camera.presenter;

import android.graphics.Bitmap;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.uncreated.docproof.model.documents.TempDocumentRepository;
import com.uncreated.docproof.ui.fragments.camera.view.CameraView;

import javax.inject.Inject;

@InjectViewState
public class CameraPresenter extends MvpPresenter<CameraView> {

    @Inject
    TempDocumentRepository tempDocumentRepository;

    public void onFirstCreate() {
        getViewState().goMakePhoto();

        tempDocumentRepository.createDocument();
    }

    public void onRecreate() {

    }

    public void addNewPage(Bitmap bitmap) {

    }

    public void saveDocument() {
        getViewState().goDocument(123);
    }
}
