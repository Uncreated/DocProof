package com.uncreated.docproof.ui.fragments.document.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.uncreated.docproof.R;
import com.uncreated.docproof.model.documents.DocumentRepository;
import com.uncreated.docproof.ui.fragments.document.view.DocumentView;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

@InjectViewState
public class DocumentPresenter extends MvpPresenter<DocumentView> {

    @Inject
    DocumentRepository documentRepository;

    @Inject
    @Named("mainThread")
    Scheduler mainThreadScheduler;

    private Disposable documentDisposable;

    public void setDocumentIndex(int index) {
        documentDisposable = documentRepository.getDocument(index)
                .observeOn(mainThreadScheduler)
                .subscribe(document -> getViewState().onDocument(document),
                        this::onThrowable);
    }

    private void onThrowable(Throwable throwable) {
        Timber.e(throwable);
        getViewState().onSoftError(R.string.error_message_document_load_fail);
        getViewState().goBack();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (documentDisposable != null) {
            documentDisposable.dispose();
        }
    }
}
