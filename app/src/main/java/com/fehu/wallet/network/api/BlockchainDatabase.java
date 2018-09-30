package com.fehu.wallet.network.api;

import android.content.Context;

import com.fehu.wallet.da.BlockchainDao;
import com.fehu.wallet.network.models.BlockchainCurrencyPrices;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */

@Database(entities = {BlockchainCurrencyPrices.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class BlockchainDatabase extends RoomDatabase {
    private static BlockchainDatabase instance;

    public abstract BlockchainDao blockchainDao();

    public static synchronized BlockchainDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), BlockchainDatabase.class, "blockchain-currency-database").build();
        }
        return instance;
    }
}