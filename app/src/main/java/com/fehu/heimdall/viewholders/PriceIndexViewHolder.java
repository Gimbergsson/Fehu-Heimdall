package com.fehu.heimdall.viewholders;

import android.view.View;
import android.widget.TextView;

import com.fehu.heimdall.R;
import com.fehu.heimdall.network.models.FehuIndex;
import com.fehu.heimdall.network.models.PriceIndex;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dennis Gimbergsson on 2018-10-01.
 */
public abstract class PriceIndexViewHolder extends BaseViewHolder<PriceIndex> {

    @BindView(R.id.product_title)
    TextView mainPriceIndex;

    public PriceIndexViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void setFehuIndex(FehuIndex fehuIndex) {
        mainPriceIndex.setText(fehuIndex.getSekBTC());
    }
}
