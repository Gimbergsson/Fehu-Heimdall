package com.fehu.wallet.network.models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
@Entity
public class FiatCurrency {

    @NonNull
    //PrimaryKey
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

    public FiatCurrency(@NonNull String fifteenMinutes, @NonNull String lastPrice, @NonNull String buyPrice, @NonNull String sellPrice, String currencySymbol) {
        this.fifteenMinutes = fifteenMinutes;
        this.lastPrice = lastPrice;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.currencySymbol = currencySymbol;
    }

    @NonNull
    public String getFifteenMinutes() {
        return fifteenMinutes;
    }

    public void setFifteenMinutes(@NonNull String fifteenMinutes) {
        this.fifteenMinutes = fifteenMinutes;
    }

    @NonNull
    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(@NonNull String lastPrice) {
        this.lastPrice = lastPrice;
    }

    @NonNull
    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(@NonNull String buyPrice) {
        this.buyPrice = buyPrice;
    }

    @NonNull
    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(@NonNull String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
