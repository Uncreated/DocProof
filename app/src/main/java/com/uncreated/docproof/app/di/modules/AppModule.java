package com.uncreated.docproof.app.di.modules;

import android.content.Context;

import com.uncreated.docproof.app.App;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public App app() {
        return app;
    }

    @Named("mainThread")
    @Provides
    public Scheduler mainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Named("application")
    @Provides
    public Context applicationContext() {
        return app.getApplicationContext();
    }
}
