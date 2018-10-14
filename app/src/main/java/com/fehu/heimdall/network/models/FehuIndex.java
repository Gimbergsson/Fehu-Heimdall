package com.fehu.heimdall.network.models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Dennis Gimbergsson on 2018-10-01.
 */
@Entity
public class FehuIndex {

    @NonNull
    @PrimaryKey
    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("usdSAT")
    private String usdBTC;

    @SerializedName("usdSAT")
    private String usdSAT;

    @SerializedName("sekBTC")
    private String sekBTC;

    @SerializedName("sekSAT")
    private String sekSAT;

    FehuIndex(@NonNull String timestamp, String usdBTC, String usdSAT, String sekBTC, String sekSAT) {
        this.timestamp = timestamp;
        this.usdBTC = usdBTC;
        this.usdSAT = usdSAT;
        this.sekBTC = sekBTC;
        this.sekSAT = sekSAT;
    }

    @NonNull
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsdBTC() {
        return usdBTC;
    }

    public void setUsdBTC(String usdBTC) {
        this.usdBTC = usdBTC;
    }

    public String getUsdSAT() {
        return usdSAT;
    }

    public void setUsdSAT(String usdSAT) {
        this.usdSAT = usdSAT;
    }

    public String getSekBTC() {
        return sekBTC;
    }

    public void setSekBTC(String sekBTC) {
        this.sekBTC = sekBTC;
    }

    public String getSekSAT() {
        return sekSAT;
    }

    public void setSekSAT(String sekSAT) {
        this.sekSAT = sekSAT;
    }

    /*public void buildIndex(Context context, final Callback<BlockchainCurrencyPrices> callback) {

        Gson gson = new Gson();

        FehuIndex.Builder fehuIndexBuilder = new FehuIndex.Builder();

        FehuDao fehuDao = FehuDatabase.getDatabase(context).exchangePricesModel();
        BlockchainCurrencyPrices blockchainCurrencyPricesList = fehuDao.getRawBlockchainCurrencyPrices();


        int usdBTC = 0;
        usdBTC = Integer.valueOf(blockchainCurrencyPricesList.getUsd().getLastPrice());

        int usdSAT = 0;
        usdSAT = Integer.valueOf(blockchainCurrencyPricesList.getUsd().getLastPrice()) / 100000000;
    }*/

    public static class Builder {
        @NonNull
        @PrimaryKey
        @SerializedName("timestamp")
        private String timestamp;

        @SerializedName("usdSAT")
        private String usdBTC;

        @SerializedName("usdSAT")
        private String usdSAT;

        @SerializedName("sekBTC")
        private String sekBTC;

        @SerializedName("sekSAT")
        private String sekSAT;

        /*Builder(@NonNull String timestamp, String usdBTC, String usdSAT, String sekBTC, String sekSAT) {
            this.timestamp = timestamp;
            this.usdBTC = usdBTC;
            this.usdSAT = usdSAT;
            this.sekBTC = sekBTC;
            this.sekSAT = sekSAT;
        }*/
        Builder() {
        }

        public Builder timestamp(final String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder usdBTC(final String usdBTC) {
            this.usdBTC = usdBTC;
            return this;
        }

        public Builder usdSAT(final String usdSAT) {
            this.usdSAT = usdSAT;
            return this;
        }

        public Builder sekBTC(final String sekBTC) {
            this.sekBTC = sekBTC;
            return this;
        }

        public Builder sekSAT(final String sekSAT) {
            this.sekSAT = sekSAT;
            return this;
        }

        public FehuIndex Build() {
            return new FehuIndex(timestamp, usdBTC, usdSAT, sekBTC, sekSAT);
        }

    }

}
