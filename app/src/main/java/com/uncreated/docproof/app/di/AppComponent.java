package com.uncreated.docproof.app.di;


import com.uncreated.docproof.app.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
}
