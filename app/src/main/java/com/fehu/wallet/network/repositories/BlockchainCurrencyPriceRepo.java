package com.fehu.wallet.network.repositories;

import com.fehu.wallet.da.BlockchainDao;
import com.fehu.wallet.network.api.BlockchainApi;
import com.fehu.wallet.network.models.BlockchainCurrencyPrices;

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

    private final BlockchainApi blockchainApi;

    public BlockchainCurrencyPriceRepo(BlockchainDao blockchainDao, BlockchainApi blockchainApi) {
        this.blockchainDao = blockchainDao;
        this.blockchainApi = blockchainApi;

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
        return blockchainDao.getBlockchainCurrencyPrices();
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
            if (blockchainDao != null) {
                //new Thread(() -> blockchainDao.insertReadings(blockchainCurrencyPricesList.toArray(array))).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //blockchainCurrencyPrices.setTimestamp(System.currentTimeMillis());
                        //blockchainDao.deleteOld();
                        //blockchainDao.delete();
                        blockchainDao.insertBlockchain(blockchainCurrencyPrices);
                    }
                }).start();
            }
        }
    }
}
