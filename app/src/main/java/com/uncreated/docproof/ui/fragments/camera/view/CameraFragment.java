package com.uncreated.docproof.ui.fragments.camera.view;

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

public class CameraFragment extends Fragment {

    private OnInteractionListener listener;
    private Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.btn_save)
    public void onSaveClick(View view) {
        Bundle arguments = new Bundle();
        arguments.putInt(DocumentFragment.DOCUMENT_ID, 22);

        Navigation.findNavController(view)
                .navigate(R.id.action_fragment_camera_to_document, arguments);
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
