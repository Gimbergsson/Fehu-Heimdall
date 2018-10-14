package com.fehu.heimdall.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.fehu.heimdall.R;
import com.fehu.heimdall.network.api.ApiManager;
import com.fehu.heimdall.network.models.BlockchainCurrencyPrices;
import com.fehu.heimdall.network.repositories.BitstampCurrencyPriceRepo;
import com.fehu.heimdall.viewmodels.BlockchainCurrencyViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dennis Gimbergsson on 2018-09-15.
 */
public class MainFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static String TAG = "MainFragment";

    private Context context;
    private BlockchainCurrencyViewModel blockchainCurrencyViewModel;
    private Observer<BlockchainCurrencyPrices> blockchainCurrencyPricesListObserver;
    private View rootView;
    private ApiManager apiManager;

    public MainFragment getInstance() {
        return new MainFragment();
    }

    @BindView(R.id.container)
    ConstraintLayout container;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        apiManager = ApiManager.getInstance();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* final ProgressDialog dialogBuilder = new ProgressDialog(getActivity());
                dialogBuilder.setTitle("Loading");
                dialogBuilder.setIndeterminate(true);
                dialogBuilder.show();*/

                /*BlockchainCurrencyPriceRepo currencyPriceRepo = apiManager.getBlockchainCurrencyPricesRepo(getActivity());*/

                /*if (currencyPriceRepo.loadCurrencyPrices().getValue() != null) {
                    String price = currencyPriceRepo.loadCurrencyPrices().getValue().getUsd().getFifteenMinutes();
                }*/

                /*currencyPriceRepo.loadCurrencyPrices(new Callback<BlockchainCurrencyPrices>() {
                    @Override
                    public void onResponse(@NonNull Call<BlockchainCurrencyPrices> call, @NonNull Response<BlockchainCurrencyPrices> response) {
                        dialogBuilder.dismiss();
                    }

                    @Override
                    public void onFailure(@NonNull Call<BlockchainCurrencyPrices> call, @NonNull Throwable throwable) {
                        dialogBuilder.dismiss();

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                        alertDialogBuilder.setTitle(throwable.getMessage())
                                .show();
                    }
                });*/

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                BitstampCurrencyPriceRepo bitstampCurrencyPriceRepo = apiManager.getBitsampCurrencyPriceBtcUsd(getActivity());
                bitstampCurrencyPriceRepo.loadCurrencyPrices();
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (getFragmentManager() == null) {
            return false;
        }

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                transaction.replace(R.id.page_container, new HomeFragment().getInstance());
                break;
            case R.id.navigation_dashboard:
                transaction.replace(R.id.page_container, new CheckoutFragment().getInstance());
                break;
            case R.id.navigation_scanner:
                transaction.replace(R.id.page_container, new ScannerFragment().getInstance());
                break;
            case R.id.navigation_notifications:
                transaction.replace(R.id.page_container, new AccountFragment().getInstance());
                break;
        }

        transaction.commit();
        return true;
    }
}
