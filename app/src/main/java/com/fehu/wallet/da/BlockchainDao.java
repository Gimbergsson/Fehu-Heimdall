package com.fehu.wallet.da;

import com.fehu.wallet.network.models.BlockchainCurrencyPrices;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.ABORT;
import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
@Dao
public interface BlockchainDao {

    @Insert(onConflict = REPLACE)
    void insertBlcokchainCurrencyPrices(BlockchainCurrencyPrices... blockchainCurrencyPrices);

    /*@Query("SELECT COUNT(*) FROM Reading INNER JOIN(SELECT origin, MAX(timestamp) AS maxtimestamp FROM Reading GROUP BY origin) mts ON Reading.origin = mts.origin AND timestamp = maxtimestamp")
    int loadNumberOfOrigins();*/

    /*@Query("SELECT * FROM Reading INNER JOIN(SELECT origin, MAX(timestamp) AS maxtimestamp FROM Reading GROUP BY origin) mts ON Reading.origin = mts.origin AND timestamp = maxtimestamp")
    LiveData<List<BlockchainCurrencyPrices>> loadLatest();*/

    /*@Query("SELECT * FROM BlockchainCurrencyPrices")
    LiveData<List<LatestBlockchainCurrencyPricesResult>> loadAll();*/

    /*@Query("SELECT * FROM Reading WHERE origin = :origin AND timestamp BETWEEN :minTime AND :maxTime")
    LiveData<List<Reading>> loadRange(String origin, long minTime, long maxTime);*/

    @Query("DELETE FROM BlockchainCurrencyPrices where timestamp NOT IN (SELECT timestamp from BlockchainCurrencyPrices LIMIT 1000)")
    void truncate();

    /*@Query("DELETE FROM BlockchainCurrencyPrices")
    void deleteAll();*/

    @Delete
    void delete(BlockchainCurrencyPrices blockchainCurrencyPrices);

    @Query("Delete FROM BlockchainCurrencyPrices where timestamp > (Select timestamp from BlockchainCurrencyPrices)")
    void deleteOld();

    @Insert(onConflict = ABORT)
    void insertBlockchain(BlockchainCurrencyPrices blockchainCurrencyPricesList);

    @Query("SELECT * FROM BlockchainCurrencyPrices")
    LiveData<BlockchainCurrencyPrices> getBlockchainCurrencyPrices();
}
