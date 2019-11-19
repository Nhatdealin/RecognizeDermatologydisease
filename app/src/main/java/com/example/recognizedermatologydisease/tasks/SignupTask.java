package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.SignupOutput;
import com.example.recognizedermatologydisease.api.objects.SignupInput;

public class SignupTask extends BaseTask <SignupOutput> {
    SignupInput signup;
    public SignupTask(Context context, SignupInput signup, @Nullable ApiListener<SignupOutput> listener) {
        super(context, listener);
        this.signup = signup ;
    }

    @Override
    protected SignupOutput callApiMethod() throws Exception {
        return mApi.signUpAccount(signup);
    }
}
