package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.ProfileOutput;

public class GetProfileTask extends BaseTask <ProfileOutput> {

    public GetProfileTask(Context context, @Nullable ApiListener<ProfileOutput> listener) {
        super(context, listener);
    }

    @Override
    protected ProfileOutput callApiMethod() throws Exception {
        return mApi.getProfile();
    }
}
