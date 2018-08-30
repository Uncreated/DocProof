package com.uncreated.docproof.ui.fragments.documents.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.uncreated.docproof.R;
import com.uncreated.docproof.model.documents.DocumentRepository;
import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.ui.fragments.documents.view.DocumentsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

@InjectViewState
public class DocumentsPresenter extends MvpPresenter<DocumentsView> {

    @Inject
    DocumentRepository documentRepository;

    @Inject
    @Named("mainThread")
    Scheduler mainThreadScheduler;

    private List<Document> documents = new ArrayList<>();

    private Disposable documentsDisposable;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        documentsDisposable = documentRepository.getDocuments()
                .observeOn(mainThreadScheduler)
                .subscribe(this::onDocument, this::onCriticalThrowable);
    }
    //TODO: загрузку превью документа сюда не пихать, создать fragmentDocumentItem в recyclerView

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (documentsDisposable != null) {
            documentsDisposable.dispose();
        }
    }

    private void onDocument(Document document) {
        documents.add(document);
        getViewState().onDocumentsChanged(documents);
    }

    private void onCriticalThrowable(Throwable throwable) {
        Timber.e(throwable);
        getViewState().onCriticalError(R.string.error_message_documents_load_fail);
    }
}
