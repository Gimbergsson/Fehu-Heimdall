package com.fehu.heimdall.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fehu.heimdall.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Dennis Gimbergsson on 2018-09-15.
 */
public class CheckoutFragment extends Fragment {

    public static String TAG = "CheckoutFragment";

    private Context context;

    public CheckoutFragment getInstance() {
        return new CheckoutFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_checkout, container, false);
    }
}
