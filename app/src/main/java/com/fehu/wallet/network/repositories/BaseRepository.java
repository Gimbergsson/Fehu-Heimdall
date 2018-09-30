package com.fehu.wallet.network.repositories;

import com.fehu.wallet.da.BlockchainDao;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public abstract class BaseRepository {

    BlockchainDao blockchainDao = null;

    public void truncateDb() {
        /*new Thread(() -> {
            if (blockchainDao != null) blockchainDao.truncate();
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (blockchainDao != null) {
                    blockchainDao.truncate();
                }
            }
        }).start();
    }

}