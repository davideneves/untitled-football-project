package com.barroco.ufp.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.barroco.ufp.BuildConfig;
import com.barroco.ufp.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    public AppDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, BuildConfig.DB_NAME).build();
    }
}
