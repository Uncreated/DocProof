package com.uncreated.docproof.ui.fragments.base;

public interface OnBaseInteractionListener {
    void onCriticalError(int messageStringId);

    void onSoftError(int messageStringId);

    void onBack();
}
