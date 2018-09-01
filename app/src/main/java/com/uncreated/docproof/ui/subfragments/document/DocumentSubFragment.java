package com.uncreated.docproof.ui.subfragments.document;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uncreated.docproof.R;
import com.uncreated.docproof.model.documents.entities.Page;
import com.uncreated.docproof.ui.fragments.base.BaseFragment;
import com.uncreated.docproof.ui.fragments.base.OnBaseInteractionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DocumentSubFragment extends BaseFragment<DocumentSubFragment.OnInteractionListener> {

    @BindView(R.id.rv_pages)
    RecyclerView recyclerView;

    private PagesAdapter pagesAdapter;
    private List<Page> pages = new ArrayList<>();

    public DocumentSubFragment() {
        setLayoutId(R.layout.fragment_document_sub);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        pagesAdapter = new PagesAdapter();
        recyclerView.setAdapter(pagesAdapter);

        return view;
    }

    public void addPage(Page page) {
        pages.add(page);
        pagesAdapter.setPages(pages);
    }

    public interface OnInteractionListener extends OnBaseInteractionListener {
    }
}
