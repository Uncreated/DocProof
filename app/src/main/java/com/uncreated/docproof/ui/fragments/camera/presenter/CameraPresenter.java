package com.uncreated.docproof.ui.fragments.camera.presenter;

import android.graphics.Bitmap;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.uncreated.docproof.model.documents.TempDocumentRepository;
import com.uncreated.docproof.ui.fragments.camera.view.CameraView;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

@InjectViewState
public class CameraPresenter extends MvpPresenter<CameraView> {

    @Inject
    TempDocumentRepository tempDocumentRepository;

    @Inject
    @Named("mainThread")
    Scheduler mainThreadScheduler;

    private Disposable documentDisposable;
    private Disposable saveDisposable;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        tempDocumentRepository.createDocument();
        documentDisposable = tempDocumentRepository.createDocument()
                .observeOn(mainThreadScheduler)
                .subscribe(page -> {
                    getViewState().addPage(page);
                }, throwable -> {
                    Timber.e(throwable);
                    //TODO
                });

    }

    public void onFirstCreate() {
        getViewState().goMakePhoto();
    }

    public void addNewPage(Bitmap bitmap) {
        tempDocumentRepository.addPage(bitmap)
                .observeOn(mainThreadScheduler)
                .subscribe(() -> {

                }, throwable -> {
                    Timber.e(throwable);
                    //TODO
                });
    }

    public void saveDocument() {
        saveDisposable = tempDocumentRepository.saveDocument()
                .observeOn(mainThreadScheduler)
                .subscribe(() -> {
                    getViewState().goDocument(123);
                }, throwable -> {
                    Timber.e(throwable);
                    //TODO
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        documentDisposable.dispose();
    }
}
