package com.fehu.heimdall.db.da;

import com.fehu.heimdall.db.models.ExchangePrices;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * Created by Dennis Gimbergsson on 2018-10-03.
 */
@Dao
public interface ExchangePricesDao {

    @Insert(onConflict = REPLACE)
    void insertExchangePrices(ExchangePrices exchangePrices);

    @Update
    void updateExchangePrices(ExchangePrices exchangePrices);

    @Query("SELECT * FROM ExchangePrices")
    LiveData<ExchangePrices> getExchangePrices();

}