package com.fehu.heimdall.network.models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
@Entity
public class FiatCurrency {

    /*@PrimaryKey
    int id = 0;*/

    @NonNull
    //@PrimaryKey
    @SerializedName("15m")
    String fifteenMinutes;

    @NonNull
    //@PrimaryKey
    @SerializedName("last")
    private String lastPrice;

    @NonNull
    //@PrimaryKey
    @SerializedName("buy")
    private String buyPrice;

    @NonNull
    //@PrimaryKey
    @SerializedName("sell")
    private String sellPrice;

    @SerializedName("symbol")
    private String currencySymbol;

    public FiatCurrency(String fifteenMinutes, String lastPrice, String buyPrice, String sellPrice, String currencySymbol) {
        this.fifteenMinutes = fifteenMinutes;
        this.lastPrice = lastPrice;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.currencySymbol = currencySymbol;
    }


    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getFifteenMinutes() {
        return fifteenMinutes;
    }

    public void setFifteenMinutes(String fifteenMinutes) {
        this.fifteenMinutes = fifteenMinutes;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
