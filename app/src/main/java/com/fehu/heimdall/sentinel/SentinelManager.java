package com.fehu.heimdall.sentinel;

/**
 * Created by Dennis Gimbergsson on 2018-10-06.
 */
public class SentinelManager {

    private static SentinelManager instance = new SentinelManager();

    public SentinelManager() {
    }

    public static SentinelManager getInstance() {
        return instance;
    }
}
