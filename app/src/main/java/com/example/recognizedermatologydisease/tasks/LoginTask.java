package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.LoginOutput;
import com.example.recognizedermatologydisease.api.objects.LoginInput;

public class LoginTask  extends BaseTask <LoginOutput> {
    LoginInput login;
    public LoginTask(Context context, LoginInput login, @Nullable ApiListener<LoginOutput> listener) {
        super(context, listener);
        this.login = login;
    }

    @Override
    protected LoginOutput callApiMethod() throws Exception {
        return mApi.loginUsername(login);
    }
}
