package com.fehu.wallet.viewholders;

import android.view.View;
import android.widget.TextView;

import com.fehu.wallet.R;
import com.fehu.wallet.network.models.FehuIndex;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dennis Gimbergsson on 2018-10-01.
 */
public abstract class FehuIndexViewHolder extends BaseViewHolder<FehuIndex> {

    @BindView(R.id.product_title)
    TextView mainPriceIndex;

    public FehuIndexViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void setFehuIndex(FehuIndex fehuIndex) {
        mainPriceIndex.setText(fehuIndex.getSekBTC());
    }
}
