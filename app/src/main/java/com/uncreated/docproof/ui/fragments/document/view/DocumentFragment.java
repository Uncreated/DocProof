package com.uncreated.docproof.ui.fragments.document.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.uncreated.docproof.R;
import com.uncreated.docproof.app.App;
import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.ui.fragments.base.BaseFragment;
import com.uncreated.docproof.ui.fragments.base.OnBaseInteractionListener;
import com.uncreated.docproof.ui.fragments.document.presenter.DocumentPresenter;

import androidx.navigation.Navigation;
import butterknife.BindView;

public class DocumentFragment extends BaseFragment<DocumentFragment.OnInteractionListener>
        implements DocumentView {

    public static final String DOCUMENT_ID = "documentId";

    @BindView(R.id.textView)
    TextView textView;

    @InjectPresenter
    DocumentPresenter presenter;

    public DocumentFragment() {
        setLayoutId(R.layout.fragment_document);
    }

    @ProvidePresenter
    public DocumentPresenter provideDocumentPresenter() {
        DocumentPresenter documentPresenter = new DocumentPresenter();
        App.getApp().getAppComponent().inject(documentPresenter);
        return documentPresenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState == null) {
            Bundle arguments = getArguments();
            if (arguments == null)
                throw new RuntimeException(getClass().getSimpleName() + "need some arguments");

            Integer documentId = arguments.getInt(DOCUMENT_ID, 0);
            presenter.setDocumentIndex(documentId);
            textView.setText(String.format("%s(%d)", textView.getText(), documentId));
        }
        return view;
    }

    @Override
    public void onDocument(Document document) {
        //TODO
    }

    @Override
    public boolean onBackNavigate() {
        Navigation.findNavController(getView())
                .navigate(R.id.action_fragment_document_to_documents);

        return true;
    }

    public interface OnInteractionListener extends OnBaseInteractionListener {
    }
}
