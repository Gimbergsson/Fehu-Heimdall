package com.fehu.heimdall.network.repositories;

import com.fehu.heimdall.db.da.FehuDao;
import com.fehu.heimdall.network.api.ApiManager;
import com.fehu.heimdall.network.models.BlockchainCurrencyPrices;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public class BlockchainCurrencyPriceRepo extends BaseRepository {

    private final String TAG = BlockchainCurrencyPriceRepo.class.getSimpleName();

    private final ApiManager.BlockchainApi blockchainApi;

    public BlockchainCurrencyPriceRepo(FehuDao fehuDao, ApiManager.BlockchainApi blockchainApi) {
        this.fehuDao = fehuDao;
        this.blockchainApi = blockchainApi;

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

    public LiveData<BlockchainCurrencyPrices> loadCurrencyPrices(Callback<BlockchainCurrencyPrices> callback) {
        refresh(callback);
        return fehuDao.getBlockchainCurrencyPrices();
    }

    @WorkerThread
    private void refresh(final Callback<BlockchainCurrencyPrices> callback) {
        if (blockchainApi != null) {
            Call<BlockchainCurrencyPrices> call = blockchainApi.getBlockchainCurrencyPrices();
            call.enqueue(new Callback<BlockchainCurrencyPrices>() {
                @Override
                public void onResponse(@NonNull Call<BlockchainCurrencyPrices> call, @NonNull Response<BlockchainCurrencyPrices> response) {
                    if (response.isSuccessful()) {
                        insertReadings(response.body());
                    }
                    callback.onResponse(call, response);
                }

                @Override
                public void onFailure(@NonNull Call<BlockchainCurrencyPrices> call, @NonNull Throwable t) {
                    t.printStackTrace();
                    callback.onFailure(call, t);
                }
            });
        }
    }

    private void insertReadings(final BlockchainCurrencyPrices blockchainCurrencyPrices) {
        if (blockchainCurrencyPrices != null) {
            //final BlockchainCurrencyPrices[] array = new BlockchainCurrencyPrices[blockchainCurrencyPricesList.size()];
            if (fehuDao != null) {
                //new Thread(() -> fehuDao.insertReadings(blockchainCurrencyPricesList.toArray(array))).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //blockchainCurrencyPrices.setTimestamp(System.currentTimeMillis());
                        //fehuDao.deleteOld();
                        //fehuDao.delete();
                        fehuDao.insertBlockchain(blockchainCurrencyPrices);
                    }
                }).start();
            }
        }
    }
}
