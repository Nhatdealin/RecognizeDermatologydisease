package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.ChangePasswordOutput;
import com.example.recognizedermatologydisease.api.objects.ChangePasswordInput;

public class ChangePasswordTask extends BaseTask <ChangePasswordOutput> {
    ChangePasswordInput changePasswordInput;
    public ChangePasswordTask(Context context, ChangePasswordInput changePasswordInput, @Nullable ApiListener<ChangePasswordOutput> listener) {
        super(context, listener);
        this.changePasswordInput = changePasswordInput;
    }

    @Override
    protected ChangePasswordOutput callApiMethod() throws Exception {
        return mApi.changePassword(changePasswordInput);
    }
}
