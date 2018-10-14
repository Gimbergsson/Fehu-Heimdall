package com.fehu.heimdall.network.models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
@Entity
public class BlockchainCurrencyPrices {

    @NonNull
    @PrimaryKey
    private int timestamp = 0;

    @SerializedName("USD")
    private FiatCurrency usd;

    @SerializedName("EUR")
    private FiatCurrency eur;

    @SerializedName("SEK")
    private FiatCurrency sek;

    public BlockchainCurrencyPrices(@NonNull int timestamp) {
        this.timestamp = timestamp;
    }

    @NonNull
    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull int timestamp) {
        this.timestamp = timestamp;
    }

    public FiatCurrency getUsd() {
        return usd;
    }

    public void setUsd(FiatCurrency usd) {
        this.usd = usd;
    }

    public FiatCurrency getEur() {
        return eur;
    }

    public void setEur(FiatCurrency eur) {
        this.eur = eur;
    }

    public FiatCurrency getSek() {
        return sek;
    }

    public void setSek(FiatCurrency sek) {
        this.sek = sek;
    }
}
