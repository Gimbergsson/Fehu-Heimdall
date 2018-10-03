package com.fehu.wallet.db;

import com.fehu.wallet.network.models.FiatCurrency;
import com.google.gson.Gson;

import androidx.room.TypeConverter;

/**
 * Created by Dennis Gimbergsson on 2018-09-23.
 */
public class Converters {

    private static Gson gson = new Gson();

    /*@TypeConverter
    public static ArrayList<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayLisr(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }*/

    /*@TypeConverter
    public static FiatCurrency fromFiatCurrency(String string) {

        return string == null ? null : new FiatCurrency(string, "2","3","4", "5");
    }*/

    /*@TypeConverter
    public static BlockchainCurrencyPrices fromBlockchainCurrencyPrices(String string) {
        // TODO convert with a better way??
        return gson.fromJson(string, BlockchainCurrencyPrices.class);
    }

    @TypeConverter
    public static String blockchainCurrencyPricesToTimestamp(BlockchainCurrencyPrices blockchainCurrencyPrices) {
        // TODO convert with a better way??
        blockchainCurrencyPrices.setTimestamp(System.currentTimeMillis());
        return gson.toJson(blockchainCurrencyPrices);
    }*/

    @TypeConverter
    public static FiatCurrency fromFiatCurrency(String string) {
        // TODO convert with a better way??
        return gson.fromJson(string, FiatCurrency.class);
    }

    @TypeConverter
    public static String fiatCurrencyToTimestamp(FiatCurrency fiatCurrency) {
        // TODO convert with a better way??
        return gson.toJson(fiatCurrency);
    }
}
