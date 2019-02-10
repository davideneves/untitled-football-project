package com.barroco.ufp.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.barroco.ufp.database.model.Player;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM players")
    List<Player> getAll();

    @Insert
    void insertAll(Player... players);

    @Delete
    void delete(Player player);
}
