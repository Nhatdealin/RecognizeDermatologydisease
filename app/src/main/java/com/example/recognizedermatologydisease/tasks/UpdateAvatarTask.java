package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.AvatarOutput;

import java.io.File;

public class UpdateAvatarTask extends BaseTask <AvatarOutput> {
    File updateFile;
    public UpdateAvatarTask(Context context, File updateFile, @Nullable ApiListener<AvatarOutput> listener) {
        super(context, listener);
        this.updateFile = updateFile;
    }

    @Override
    protected AvatarOutput callApiMethod() throws Exception {
        return mApi.updateAvatar(updateFile);
    }
}
