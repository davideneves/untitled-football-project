package com.barroco.ufp;

import android.app.Application;

import com.barroco.ufp.util.log.ReleaseTree;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupTimber();
        setupRealm();
    }

    private void setupRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(BuildConfig.DB_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }
}
