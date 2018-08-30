package com.uncreated.docproof.ui.fragments.document.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uncreated.docproof.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DocumentFragment extends Fragment {

    public static final String DOCUMENT_ID = "documentId";
    @BindView(R.id.textView)
    TextView textView;
    private OnInteractionListener listener;
    private Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_document, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (savedInstanceState == null) {
            Bundle arguments = getArguments();
            if (arguments == null)
                throw new RuntimeException(getClass().getSimpleName() + "need some arguments");

            Integer documentId = arguments.getInt(DOCUMENT_ID, 0);
            textView.setText(String.format("%s(%d)", textView.getText(), documentId));
        }
        return view;
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
