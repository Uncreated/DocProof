package com.uncreated.docproof.ui.fragments.documents.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import butterknife.BindView;
import butterknife.OnClick;

public class DocumentsFragment extends BaseFragment<DocumentsFragment.OnInteractionListener>
        implements DocumentsView {

    @InjectPresenter
    DocumentsPresenter presenter;

    @BindView(R.id.rv_documents)
    RecyclerView recyclerView;
    private DocumentsAdapter documentsAdapter;

    public DocumentsFragment() {
        setLayoutId(R.layout.fragment_documents);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        documentsAdapter = new DocumentsAdapter(index -> {
            Bundle arguments = new Bundle();
            arguments.putInt(DocumentFragment.DOCUMENT_ID, index);

            Navigation.findNavController(getView())
                    .navigate(R.id.action_fragment_documents_to_document, arguments);
        });
        recyclerView.setAdapter(documentsAdapter);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        return view;
    }

    @ProvidePresenter
    public DocumentsPresenter provideDocumentsPresenter() {
        DocumentsPresenter documentsPresenter = new DocumentsPresenter();
        App.getApp().getAppComponent().inject(documentsPresenter);
        return documentsPresenter;
    }

    @Override
    public void onDocumentsChanged(List<Document> documents) {
        documentsAdapter.setDocuments(documents);
    }

    @Override
    public void onThumbnailLoaded(Bitmap bitmap, int index) {
        //TODO
    }

    @OnClick(R.id.fab_new_document)
    public void onNewClick(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_fragment_documents_to_camera);
    }

    public interface OnInteractionListener extends OnBaseInteractionListener {
    }
}
