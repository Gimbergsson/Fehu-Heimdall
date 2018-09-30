package com.fehu.wallet.network.api;

import com.fehu.wallet.network.models.BlockchainCurrencyPrices;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public interface BlockchainApi {

    @GET("/ticker")
    Call<BlockchainCurrencyPrices> getBlockchainCurrencyPrices();

}
