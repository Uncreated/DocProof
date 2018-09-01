package com.uncreated.docproof.ui.fragments.camera.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.uncreated.docproof.R;
import com.uncreated.docproof.app.App;
import com.uncreated.docproof.ui.fragments.base.BaseFragment;
import com.uncreated.docproof.ui.fragments.base.OnBaseInteractionListener;
import com.uncreated.docproof.ui.fragments.camera.presenter.CameraPresenter;
import com.uncreated.docproof.ui.fragments.document.view.DocumentFragment;

import androidx.navigation.Navigation;
import butterknife.OnClick;

public class CameraFragment extends BaseFragment<CameraFragment.OnInteractionListener>
        implements CameraView {

    @InjectPresenter
    CameraPresenter presenter;

    public CameraFragment() {
        setLayoutId(R.layout.fragment_camera);
    }

    @ProvidePresenter
    public CameraPresenter provideCameraPresenter() {
        CameraPresenter cameraPresenter = new CameraPresenter();
        App.getApp().getAppComponent().inject(cameraPresenter);
        return cameraPresenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (savedInstanceState == null) {
            presenter.onFirstCreate();
        }

        return view;
    }

    @OnClick(R.id.btn_save)
    public void onSaveClick(View view) {
        presenter.saveDocument();
    }

    @Override
    public void goMakePhoto() {
        getListener().makePhoto();
    }

    @Override
    public void goDocument(int index) {
        Bundle arguments = new Bundle();
        arguments.putInt(DocumentFragment.DOCUMENT_ID, index);

        Navigation.findNavController(getView())
                .navigate(R.id.action_fragment_camera_to_document, arguments);
    }

    public void cameraResult(Bitmap imageBitmap) {
        presenter.addNewPage(imageBitmap);
    }

    public interface OnInteractionListener extends OnBaseInteractionListener {
        void makePhoto();
    }
}
