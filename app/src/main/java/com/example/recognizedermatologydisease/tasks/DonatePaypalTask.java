package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.PaypalDonationOutput;
import com.example.recognizedermatologydisease.api.objects.PaypalDonationInput;

public class DonatePaypalTask extends BaseTask <PaypalDonationOutput> {
    PaypalDonationInput paypalDonationInput;
    public DonatePaypalTask(Context context, PaypalDonationInput paypalDonationInput, @Nullable ApiListener<PaypalDonationOutput> listener) {
        super(context, listener);
        this.paypalDonationInput = paypalDonationInput ;
    }

    @Override
    protected PaypalDonationOutput callApiMethod() throws Exception {
        return mApi.donatePaypal(paypalDonationInput);
    }
}
