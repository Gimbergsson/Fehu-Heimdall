package com.fehu.heimdall.viewholders;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Dennis Gimbergsson on 2018-10-01.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View view) {
        super(view);
    }

    public abstract void configure(T data);
}

