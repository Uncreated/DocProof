package com.uncreated.docproof.ui.fragments.documents.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.uncreated.docproof.R;
import com.uncreated.docproof.app.App;
import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.ui.fragments.base.BaseFragment;
import com.uncreated.docproof.ui.fragments.base.OnBaseInteractionListener;
import com.uncreated.docproof.ui.fragments.document.view.DocumentFragment;
import com.uncreated.docproof.ui.fragments.documents.presenter.DocumentsPresenter;

import java.util.List;

import androidx.navigation.Navigation;
import butterknife.OnClick;

public class DocumentsFragment extends BaseFragment<DocumentsFragment.OnInteractionListener>
        implements DocumentsView {

    @InjectPresenter
    DocumentsPresenter presenter;

    public DocumentsFragment() {
        setLayoutId(R.layout.fragment_documents);
    }

    @ProvidePresenter
    public DocumentsPresenter provideDocumentsPresenter() {
        DocumentsPresenter documentsPresenter = new DocumentsPresenter();
        App.getApp().getAppComponent().inject(documentsPresenter);
        return documentsPresenter;
    }

    @Override
    public void onDocumentsChanged(List<Document> documents) {
        //TODO
    }

    @Override
    public void onThumbnailLoaded(Bitmap bitmap, int index) {
        //TODO
    }

    @OnClick(R.id.btn_new)
    public void onNewClick(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_fragment_documents_to_camera);
    }

    @OnClick(R.id.btn_open)
    public void onOpenClick(View view) {
        Bundle arguments = new Bundle();
        arguments.putInt(DocumentFragment.DOCUMENT_ID, 11);

        Navigation.findNavController(view)
                .navigate(R.id.action_fragment_documents_to_document, arguments);
    }

    public interface OnInteractionListener extends OnBaseInteractionListener {
    }
}
