package com.uncreated.docproof.ui.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.uncreated.docproof.R;
import com.uncreated.docproof.ui.fragments.camera.view.CameraFragment;
import com.uncreated.docproof.ui.fragments.document.view.DocumentFragment;
import com.uncreated.docproof.ui.fragments.documents.view.DocumentsFragment;

public class MainActivity extends AppCompatActivity implements
        DocumentsFragment.OnInteractionListener, CameraFragment.OnInteractionListener,
        DocumentFragment.OnInteractionListener {

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
    public void onBack() {
        onBackPressed();
    }
}
