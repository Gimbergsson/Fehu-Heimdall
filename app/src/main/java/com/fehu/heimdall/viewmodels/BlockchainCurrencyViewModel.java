package com.fehu.heimdall.viewmodels;


import com.fehu.heimdall.network.models.BlockchainCurrencyPrices;
import com.fehu.heimdall.network.repositories.BlockchainCurrencyPriceRepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public class BlockchainCurrencyViewModel extends ViewModel {

    private BlockchainCurrencyPriceRepo blockchainCurrencyPriceRepo;

    private LiveData<BlockchainCurrencyPrices> listLiveData;

    public void setRepository(BlockchainCurrencyPriceRepo repository) {
        blockchainCurrencyPriceRepo = repository;
    }

    public LiveData<BlockchainCurrencyPrices> getBlockchainCurrencyPrices() {
        listLiveData = blockchainCurrencyPriceRepo.loadCurrencyPrices(new Callback<BlockchainCurrencyPrices>() {
            @Override
            public void onResponse(Call<BlockchainCurrencyPrices> call, Response<BlockchainCurrencyPrices> response) {

            }

            @Override
            public void onFailure(Call<BlockchainCurrencyPrices> call, Throwable t) {

            }
        });
        return listLiveData;
    }
}
