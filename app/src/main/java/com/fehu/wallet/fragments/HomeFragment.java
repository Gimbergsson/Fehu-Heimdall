package com.fehu.wallet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fehu.wallet.R;
import com.fehu.wallet.network.ApiManager;
import com.fehu.wallet.network.models.BlockchainCurrencyPrices;
import com.fehu.wallet.network.repositories.BlockchainCurrencyPriceRepo;
import com.fehu.wallet.viewmodels.BlockchainCurrencyViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dennis Gimbergsson on 2018-09-15.
 */
public class HomeFragment extends Fragment {

    public static String TAG = "HomeFragment";

    private Context context;
    private BlockchainCurrencyViewModel blockchainCurrencyViewModel;
    private Observer<BlockchainCurrencyPrices> blockchainCurrencyPricesListObserver;
    private View rootView;

    public HomeFragment getInstance() {
        return new HomeFragment();
    }

    @BindView(R.id.root)
    ConstraintLayout rootConstraintLayout;

    @BindView(R.id.textView)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        ApiManager apiManager = ApiManager.getInstance();
        BlockchainCurrencyPriceRepo currencyPriceRepo = apiManager.getBlockchainCurrencyPricesRepo(getContext());

        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        final int second = calendar.get(Calendar.SECOND);

        blockchainCurrencyViewModel = ViewModelProviders.of(this).get(BlockchainCurrencyViewModel.class);
        blockchainCurrencyViewModel.setRepository(currencyPriceRepo);
        blockchainCurrencyPricesListObserver = new Observer<BlockchainCurrencyPrices>() {
            @Override
            public void onChanged(@Nullable BlockchainCurrencyPrices blockchainCurrencyPrices) {
                //setData();
                if (blockchainCurrencyPrices != null) {
                    //Snackbar.make(rootConstraintLayout, "Text", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                    String currentTime = format.format(new Date());

                    Log.d(TAG, currentTime + " " + blockchainCurrencyPrices.getSek().getBuyPrice());
                    Toast.makeText(getActivity(), currentTime + " " + blockchainCurrencyPrices.getSek().getBuyPrice(), Toast.LENGTH_SHORT).show();
                    textView.setText(blockchainCurrencyPrices.getSek().getBuyPrice() + " kr\nLast updated: " + currentTime);// + String.valueOf(hour) + ":" + String.valueOf(minute) + ":" + String.valueOf(second));
                }
            }
        };

        blockchainCurrencyViewModel.getBlockchainCurrencyPrices().observe(this, blockchainCurrencyPricesListObserver);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
