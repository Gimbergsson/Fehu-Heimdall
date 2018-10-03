package com.fehu.wallet.network.repositories;

import com.fehu.wallet.db.da.ExchangePricesDao;
import com.fehu.wallet.db.models.ExchangePrices;
import com.fehu.wallet.network.api.ApiManager;
import com.fehu.wallet.network.models.BitstampCurrencyPrices;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public class BitstampCurrencyPriceRepo extends BaseRepository {

    private final String TAG = BitstampCurrencyPriceRepo.class.getSimpleName();

    private final ApiManager.BitstampApi bitstampApi;

    public BitstampCurrencyPriceRepo(ExchangePricesDao exchangePricesDao, ApiManager.BitstampApi bitstampApi) {
        this.exchangePricesDao = exchangePricesDao;
        this.bitstampApi = bitstampApi;

        // Run every 30s
        /*final Handler handler = new Handler();
        Runnable updateRunnable = new Runnable() {
            @Override
            public void run() {
                refresh();
                handler.postDelayed(this, 30000);
            }
        };
        handler.post(updateRunnable);*/

        //refresh();
    }

    public LiveData<ExchangePrices> loadCurrencyPrices() {
        refreshBtcUsd();
        //refreshBtcEur(callback2);
        return exchangePricesDao.getExchangePrices();
    }

    @WorkerThread
    private void refreshBtcUsd() {
        if (bitstampApi != null) {
            Call<BitstampCurrencyPrices> call = bitstampApi.getBitstamBtcUsdPrices();
            call.enqueue(new Callback<BitstampCurrencyPrices>() {
                @Override
                public void onResponse(@NonNull Call<BitstampCurrencyPrices> call, @NonNull Response<BitstampCurrencyPrices> response) {
                    if (response.isSuccessful() && response.body() != null) {

                        BitstampCurrencyPrices bitstampCurrencyPrices = response.body();

                        ExchangePrices.Builder exchangePricesBuilder = new ExchangePrices.Builder();
                        exchangePricesBuilder.exchangeName("bitstamp")
                                .btcusd(bitstampCurrencyPrices.getAsk())
                                .Build();

                        ExchangePrices exchangePrices = exchangePricesBuilder.exchnageId(1)
                                .exchangeName("bitstamp")
                                .btcusd(bitstampCurrencyPrices.getAsk())
                                .Build();

                        insertReadings(exchangePrices);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<BitstampCurrencyPrices> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }

    @WorkerThread
    private void refreshBtcEur(final Callback<BitstampCurrencyPrices> callback) {
        if (bitstampApi != null) {
            Call<BitstampCurrencyPrices> call = bitstampApi.getBitstampBtcEurPrices();
            call.enqueue(new Callback<BitstampCurrencyPrices>() {
                @Override
                public void onResponse(@NonNull Call<BitstampCurrencyPrices> call, @NonNull Response<BitstampCurrencyPrices> response) {
                    if (response.isSuccessful()) {
                        //insertReadings(response.body());
                    }
                    callback.onResponse(call, response);
                }

                @Override
                public void onFailure(@NonNull Call<BitstampCurrencyPrices> call, @NonNull Throwable t) {
                    t.printStackTrace();
                    callback.onFailure(call, t);
                }
            });
        }
    }

    private void insertReadings(final ExchangePrices exchangePrices) {
        if (exchangePrices != null) {
            //final BlockchainCurrencyPrices[] array = new BlockchainCurrencyPrices[blockchainCurrencyPricesList.size()];
            if (exchangePricesDao != null) {
                //new Thread(() -> fehuDao.insertReadings(blockchainCurrencyPricesList.toArray(array))).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //bitstampCurrencyPrices.setTimestamp(System.currentTimeMillis());
                        //fehuDao.deleteOld();
                        //fehuDao.delete();
                        exchangePricesDao.insertExchangePrices(exchangePrices);
                    }
                }).start();
            }
        }
    }
}
