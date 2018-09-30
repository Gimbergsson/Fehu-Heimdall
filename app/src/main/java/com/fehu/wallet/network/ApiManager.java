package com.fehu.wallet.network;

import android.content.Context;

import com.fehu.wallet.da.BlockchainDao;
import com.fehu.wallet.network.api.BlockchainApi;
import com.fehu.wallet.network.api.BlockchainDatabase;
import com.fehu.wallet.network.repositories.BlockchainCurrencyPriceRepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        BlockchainDao blockchainDao = BlockchainDatabase.getDatabase(context).blockchainDao();
        return new BlockchainCurrencyPriceRepo(blockchainDao, blockchainApi);
    }
}
