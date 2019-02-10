package com.barroco.ufp.database;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.barroco.ufp.database.daos.PlayerDao;
import com.barroco.ufp.database.model.Player;

@android.arch.persistence.room.Database(
        entities = {Player.class},
        version = 1,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract PlayerDao playerDao();
}
