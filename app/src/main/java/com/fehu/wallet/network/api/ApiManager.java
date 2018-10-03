package com.fehu.wallet.network.api;

import android.content.Context;

import com.fehu.wallet.db.FehuDatabase;
import com.fehu.wallet.db.da.ExchangePricesDao;
import com.fehu.wallet.db.da.FehuDao;
import com.fehu.wallet.network.models.BitstampCurrencyPrices;
import com.fehu.wallet.network.models.BlockchainCurrencyPrices;
import com.fehu.wallet.network.repositories.BitstampCurrencyPriceRepo;
import com.fehu.wallet.network.repositories.BlockchainCurrencyPriceRepo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public class ApiManager {

    private static ApiManager instance = new ApiManager();

    public ApiManager() {
    }

    public static ApiManager getInstance() {
        return instance;
    }

    /*public BlockchainApi getBlockchainApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BLOCKCHAIN_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BlockchainApi.class);
    }*/

    public BlockchainCurrencyPriceRepo getBlockchainCurrencyPricesRepo(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BLOCKCHAIN_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BlockchainApi blockchainApi = retrofit.create(BlockchainApi.class);
        FehuDao fehuDao = FehuDatabase.getDatabase(context).fehuModel();
        return new BlockchainCurrencyPriceRepo(fehuDao, blockchainApi);
    }

    public interface BlockchainApi {
        @GET("/ticker")
        Call<BlockchainCurrencyPrices> getBlockchainCurrencyPrices();
    }

    public BitstampCurrencyPriceRepo getBitsampCurrencyPriceBtcUsd(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BITSTAMP_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BitstampApi bitstampApi = retrofit.create(BitstampApi.class);
        ExchangePricesDao exchangePricesDao = FehuDatabase.getDatabase(context).exchangePricesModel();
        return new BitstampCurrencyPriceRepo(exchangePricesDao, bitstampApi);
    }

    public interface BitstampApi {
        @GET("/api/v2/ticker/btcusd")
        Call<BitstampCurrencyPrices> getBitstamBtcUsdPrices();

        @GET("/api/v2/ticker/btceur")
        Call<BitstampCurrencyPrices> getBitstampBtcEurPrices();
    }
}
