package com.uncreated.docproof.ui.main.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.uncreated.docproof.R;
import com.uncreated.docproof.ui.fragments.base.BaseFragment;
import com.uncreated.docproof.ui.fragments.camera.view.CameraFragment;
import com.uncreated.docproof.ui.fragments.document.view.DocumentFragment;
import com.uncreated.docproof.ui.fragments.documents.view.DocumentsFragment;

import androidx.navigation.fragment.NavHostFragment;

public class MainActivity extends AppCompatActivity implements
        DocumentsFragment.OnInteractionListener, CameraFragment.OnInteractionListener,
        DocumentFragment.OnInteractionListener {

    public static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    public void makePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSoftError(int messageStringId) {
        Toast.makeText(this, messageStringId, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCriticalError(int messageStringId) {
        onSoftError(messageStringId);
        finish();
    }

    @Override
    public void goBack() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        getCurrentFragment().onBackNavigate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                CameraFragment cameraFragment = getCurrentFragment();
                cameraFragment.cameraResult((Bitmap) extras.get("data"));
            }
        }
    }

    @NonNull
    private <T extends BaseFragment> T getCurrentFragment() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.my_nav_host_fragment);

        return (T) navHostFragment.getChildFragmentManager().getFragments().get(0);
    }
}
