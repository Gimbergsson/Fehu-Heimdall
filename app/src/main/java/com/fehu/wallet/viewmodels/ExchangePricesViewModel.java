package com.fehu.wallet.viewmodels;


import com.fehu.wallet.db.models.ExchangePrices;
import com.fehu.wallet.network.repositories.BitstampCurrencyPriceRepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public class ExchangePricesViewModel extends ViewModel {

    private BitstampCurrencyPriceRepo bitstampCurrencyPriceRepo;

    private LiveData<ExchangePrices> exchangePricesLiveData;

    public void setRepository(BitstampCurrencyPriceRepo bitstampCurrencyPriceRepo) {
        this.bitstampCurrencyPriceRepo = bitstampCurrencyPriceRepo;
    }

    public LiveData<ExchangePrices> getExchangePricesLiveData() {
        exchangePricesLiveData = bitstampCurrencyPriceRepo.loadCurrencyPrices();
        return exchangePricesLiveData;
    }
}
