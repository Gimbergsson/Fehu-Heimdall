package com.fehu.heimdall.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis Gimbergsson on 2018-10-01.
 */

public class BitstampCurrencyPrices {

    @SerializedName("timestamp")
    private int timestamp = 0;

    @SerializedName("high")
    private String high;

    @SerializedName("bid")
    private String bid;

    @SerializedName("vwap")
    private String vwap;

    @SerializedName("volume")
    private String volume;

    @SerializedName("low")
    private String low;

    @SerializedName("ask")
    private String ask;

    @SerializedName("open")
    private String open;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getVwap() {
        return vwap;
    }

    public void setVwap(String vwap) {
        this.vwap = vwap;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
