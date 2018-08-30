package com.uncreated.docproof.app;

import android.app.Application;

import com.uncreated.docproof.app.di.AppComponent;
import com.uncreated.docproof.app.di.DaggerAppComponent;
import com.uncreated.docproof.app.di.modules.AppModule;

import timber.log.Timber;

public class App extends Application {

    private static App app;

    private AppComponent appComponent;

    public static App getApp() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Timber.plant(new Timber.DebugTree());


    }
}
