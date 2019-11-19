package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.ResultDonateOutput;

public class DonatePaypalResultTask extends BaseTask <ResultDonateOutput> {
    Long projectId;
    String paymentId,token,PayerID;
    public DonatePaypalResultTask(Context context, Long projectId,String paymentId, String token, String PayerID, @Nullable ApiListener<ResultDonateOutput> listener) {
        super(context, listener);
        this.projectId = projectId ;
        this.paymentId = paymentId ;
        this.token = token ;
        this.PayerID = PayerID ;
    }

    @Override
    protected ResultDonateOutput callApiMethod() throws Exception {
        return mApi.resultDonatePaypal(projectId,paymentId,token,PayerID);
    }
}
