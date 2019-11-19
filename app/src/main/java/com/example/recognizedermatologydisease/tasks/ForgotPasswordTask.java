package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.ForgotPasswordOutput;
import com.example.recognizedermatologydisease.api.objects.ForgotPasswordInput;

public class ForgotPasswordTask extends BaseTask <ForgotPasswordOutput> {
    ForgotPasswordInput forgotPasswordInput;
    public ForgotPasswordTask(Context context, ForgotPasswordInput forgotPasswordInput, @Nullable ApiListener<ForgotPasswordOutput> listener) {
        super(context, listener);
        this.forgotPasswordInput = forgotPasswordInput ;
    }

    @Override
    protected ForgotPasswordOutput callApiMethod() throws Exception {
        return mApi.forgotPassword(forgotPasswordInput);
    }
}
