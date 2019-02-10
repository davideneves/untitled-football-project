package com.barroco.ufp;

import android.app.Application;
import android.content.Context;

import com.barroco.ufp.di.ApplicationModule;
import com.barroco.ufp.di.ApplicationObjectGraph;
import com.barroco.ufp.di.DaggerApplicationObjectGraph;
import com.barroco.ufp.util.log.ReleaseTree;

import timber.log.Timber;

public class ApplicationController extends Application {

    private ApplicationObjectGraph mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupTimber();
        initApplicationComponent();
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }

    public static ApplicationObjectGraph getApplicationComponent(Context context) {
        ApplicationController application = ((ApplicationController) context.getApplicationContext());
        return application.getApplicationComponent();
    }

    void initApplicationComponent() {
        mApplicationComponent =
                DaggerApplicationObjectGraph.builder()
                        .applicationModule(new ApplicationModule(this))
                        .build();
    }

    private ApplicationObjectGraph getApplicationComponent() {
        return mApplicationComponent;
    }
}
