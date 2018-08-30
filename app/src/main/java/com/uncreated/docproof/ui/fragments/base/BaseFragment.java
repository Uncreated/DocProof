package com.uncreated.docproof.ui.fragments.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends OnBaseInteractionListener> extends MvpAppCompatFragment
        implements BaseFragmentView {

    private T listener;

    private int layoutId;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (T) context;
        } catch (ClassCastException e) {
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public T getListener() {
        return listener;
    }

    @Override
    public void onCriticalError(int messageStringId) {
        listener.onCriticalError(messageStringId);
    }

    @Override
    public void onSoftError(int messageStringId) {
        listener.onSoftError(messageStringId);
    }

    @Override
    public void onBack() {
        listener.onBack();
    }
}
