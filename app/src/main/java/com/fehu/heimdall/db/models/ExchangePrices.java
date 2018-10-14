package com.fehu.heimdall.db.models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Dennis Gimbergsson on 2018-10-03.
 */

@Entity(tableName = "ExchangePrices")
public class ExchangePrices {

    @SerializedName("exchangeId")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int exchangeId;

    @SerializedName("exchangeName")
    @ColumnInfo(name = "exchange_name")
    private String exchangeName;

    @SerializedName("btcusd")
    @ColumnInfo(name = "btc_usd")
    private String btcusd;

    @SerializedName("btceur")
    @ColumnInfo(name = "btc_eur")
    private String btceur;

    @SerializedName("btcsek")
    @ColumnInfo(name = "btc_sek")
    private String btcsek;

    public ExchangePrices(@NonNull int exchangeId, String exchangeName, String btcusd, String btceur, String btcsek) {
        this.exchangeId = exchangeId;
        this.exchangeName = exchangeName;
        this.btcusd = btcusd;
        this.btceur = btceur;
        this.btcsek = btcsek;
    }

    @NonNull
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getBtcusd() {
        return btcusd;
    }

    public void setBtcusd(String btcusd) {
        this.btcusd = btcusd;
    }

    public String getBtceur() {
        return btceur;
    }

    public void setBtceur(String btceur) {
        this.btceur = btceur;
    }

    public String getBtcsek() {
        return btcsek;
    }

    public void setBtcsek(String btcsek) {
        this.btcsek = btcsek;
    }

    public static class Builder {

        @SerializedName("exchangeId")
        private int exchangeId;

        @SerializedName("exchangeName")
        private String exchangeName;

        @SerializedName("btcusd")
        @ColumnInfo(name = "btc_usd")
        private String btcusd;

        @SerializedName("btceur")
        @ColumnInfo(name = "btc_eur")
        private String btceur;

        @SerializedName("btcsek")
        @ColumnInfo(name = "btc_sek")
        private String btcsek;

        /*public Builder(@NonNull int exchangeId, String exchangeName, String btcusd, String btceur, String sekSAT) {
            this.exchangeId = exchangeId;
            this.exchangeName = exchangeName;
            this.btcusd = btcusd;
            this.btceur = btceur;
            this.btcsek = btcsek;
        }*/

        public Builder() {
        }

        public ExchangePrices.Builder exchnageId(@NonNull final int exchangeId) {
            this.exchangeId = exchangeId;
            return this;
        }

        public ExchangePrices.Builder exchangeName(final String exchangeName) {
            this.exchangeName = exchangeName;
            return this;
        }

        public ExchangePrices.Builder btcusd(final String btcusd) {
            this.btcusd = btcusd;
            return this;
        }

        public ExchangePrices.Builder btceur(final String btceur) {
            this.btceur = btceur;
            return this;
        }

        public ExchangePrices.Builder btcsek(final String btcsek) {
            this.btcsek = btcsek;
            return this;
        }

        /*public FehuIndex.Builder timestamp(final String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public FehuIndex.Builder usdBTC(final String usdBTC) {
            this.usdBTC = usdBTC;
            return this;
        }

        public FehuIndex.Builder usdSAT(final String usdSAT) {
            this.usdSAT = usdSAT;
            return this;
        }

        public FehuIndex.Builder sekBTC(final String sekBTC) {
            this.sekBTC = sekBTC;
            return this;
        }

        public FehuIndex.Builder sekSAT(final String sekSAT) {
            this.sekSAT = sekSAT;
            return this;
        }*/

        public ExchangePrices Build() {
            return new ExchangePrices(exchangeId, exchangeName, btcusd, btceur, btcsek);
        }

    }
}