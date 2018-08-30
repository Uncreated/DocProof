package com.uncreated.docproof.ui.fragments.documents.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uncreated.docproof.R;
import com.uncreated.docproof.ui.fragments.document.view.DocumentFragment;

import androidx.navigation.Navigation;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DocumentsFragment extends Fragment {

    private OnInteractionListener listener;
    private Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_documents, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInteractionListener) {
            listener = (OnInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement " + getClass().getSimpleName()
                    + ".OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnInteractionListener {
    }
}
