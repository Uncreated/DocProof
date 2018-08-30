package com.uncreated.docproof.ui.fragments.base;

import com.arellomobile.mvp.MvpView;

public interface BaseFragmentView extends MvpView {
    void onCriticalError(int messageStringId);

    void onSoftError(int messageStringId);

    void onBack();
}
