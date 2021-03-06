package com.fehu.heimdall.db;

import android.content.Context;

import com.fehu.heimdall.db.da.ExchangePricesDao;
import com.fehu.heimdall.db.da.FehuDao;
import com.fehu.heimdall.db.models.ExchangePrices;
import com.fehu.heimdall.network.models.BlockchainCurrencyPrices;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */

@Database(entities = {BlockchainCurrencyPrices.class, ExchangePrices.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class FehuDatabase extends RoomDatabase {
    private static FehuDatabase instance;

    public abstract ExchangePricesDao exchangePricesModel();

    public abstract FehuDao fehuModel();

    public static synchronized FehuDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), FehuDatabase.class, "fehu-store-database").build();
        }
        return instance;
    }
}