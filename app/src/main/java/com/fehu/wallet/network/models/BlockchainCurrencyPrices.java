package com.fehu.wallet.network.models;

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
    private long timestamp;

    @SerializedName("USD")
    private FiatCurrency usd;

    @SerializedName("AUD")
    private FiatCurrency aud;

    @SerializedName("BRL")
    private FiatCurrency brl;

    @SerializedName("CAD")
    private FiatCurrency cad;

    @SerializedName("CHF")
    private FiatCurrency chf;

    @SerializedName("CLP")
    private FiatCurrency clp;

    @SerializedName("CNY")
    private FiatCurrency cny;

    @SerializedName("DKK")
    private FiatCurrency dkk;

    @SerializedName("EUR")
    private FiatCurrency eur;

    @SerializedName("GBP")
    private FiatCurrency gbp;

    @SerializedName("HKD")
    private FiatCurrency hkd;

    @SerializedName("INR")
    private FiatCurrency inr;

    @SerializedName("ISK")
    private FiatCurrency isk;

    @SerializedName("JPY")
    private FiatCurrency jpn;

    @SerializedName("KRW")
    private FiatCurrency krw;

    @SerializedName("NZD")
    private FiatCurrency nzd;

    @SerializedName("PLN")
    private FiatCurrency pln;

    @SerializedName("RUB")
    private FiatCurrency rub;

    @SerializedName("SEK")
    private FiatCurrency sek;

    @SerializedName("SGD")
    private FiatCurrency sgd;

    @SerializedName("THB")
    private FiatCurrency thb;

    @SerializedName("TWD")
    private FiatCurrency twd;

    public BlockchainCurrencyPrices(@NonNull long timestamp) {
        this.timestamp = timestamp;
    }

    @NonNull
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull long timestamp) {
        this.timestamp = timestamp;
    }

    public FiatCurrency getUsd() {
        return usd;
    }

    public void setUsd(FiatCurrency usd) {
        this.usd = usd;
    }

    public FiatCurrency getAud() {
        return aud;
    }

    public void setAud(FiatCurrency aud) {
        this.aud = aud;
    }

    public FiatCurrency getBrl() {
        return brl;
    }

    public void setBrl(FiatCurrency brl) {
        this.brl = brl;
    }

    public FiatCurrency getCad() {
        return cad;
    }

    public void setCad(FiatCurrency cad) {
        this.cad = cad;
    }

    public FiatCurrency getChf() {
        return chf;
    }

    public void setChf(FiatCurrency chf) {
        this.chf = chf;
    }

    public FiatCurrency getClp() {
        return clp;
    }

    public void setClp(FiatCurrency clp) {
        this.clp = clp;
    }

    public FiatCurrency getCny() {
        return cny;
    }

    public void setCny(FiatCurrency cny) {
        this.cny = cny;
    }

    public FiatCurrency getDkk() {
        return dkk;
    }

    public void setDkk(FiatCurrency dkk) {
        this.dkk = dkk;
    }

    public FiatCurrency getEur() {
        return eur;
    }

    public void setEur(FiatCurrency eur) {
        this.eur = eur;
    }

    public FiatCurrency getGbp() {
        return gbp;
    }

    public void setGbp(FiatCurrency gbp) {
        this.gbp = gbp;
    }

    public FiatCurrency getHkd() {
        return hkd;
    }

    public void setHkd(FiatCurrency hkd) {
        this.hkd = hkd;
    }

    public FiatCurrency getInr() {
        return inr;
    }

    public void setInr(FiatCurrency inr) {
        this.inr = inr;
    }

    public FiatCurrency getIsk() {
        return isk;
    }

    public void setIsk(FiatCurrency isk) {
        this.isk = isk;
    }

    public FiatCurrency getJpn() {
        return jpn;
    }

    public void setJpn(FiatCurrency jpn) {
        this.jpn = jpn;
    }

    public FiatCurrency getKrw() {
        return krw;
    }

    public void setKrw(FiatCurrency krw) {
        this.krw = krw;
    }

    public FiatCurrency getNzd() {
        return nzd;
    }

    public void setNzd(FiatCurrency nzd) {
        this.nzd = nzd;
    }

    public FiatCurrency getPln() {
        return pln;
    }

    public void setPln(FiatCurrency pln) {
        this.pln = pln;
    }

    public FiatCurrency getRub() {
        return rub;
    }

    public void setRub(FiatCurrency rub) {
        this.rub = rub;
    }

    public FiatCurrency getSek() {
        return sek;
    }

    public void setSek(FiatCurrency sek) {
        this.sek = sek;
    }

    public FiatCurrency getSgd() {
        return sgd;
    }

    public void setSgd(FiatCurrency sgd) {
        this.sgd = sgd;
    }

    public FiatCurrency getThb() {
        return thb;
    }

    public void setThb(FiatCurrency thb) {
        this.thb = thb;
    }

    public FiatCurrency getTwd() {
        return twd;
    }

    public void setTwd(FiatCurrency twd) {
        this.twd = twd;
    }
}
