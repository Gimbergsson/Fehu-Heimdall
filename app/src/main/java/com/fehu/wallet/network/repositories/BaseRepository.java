package com.fehu.wallet.network.repositories;

import com.fehu.wallet.db.da.ExchangePricesDao;
import com.fehu.wallet.db.da.FehuDao;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public abstract class BaseRepository {

    FehuDao fehuDao = null;
    ExchangePricesDao exchangePricesDao = null;

    public void truncateDb() {
        /*new Thread(() -> {
            if (fehuDao != null) fehuDao.truncate();
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (fehuDao != null) {
                    fehuDao.truncate();
                }
                /*if (exchangePricesDao != null) {
                    exchangePricesDao.truncate();
                }*/
            }
        }).start();
    }

}