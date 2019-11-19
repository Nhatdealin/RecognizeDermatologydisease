package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.EventOutput;

public class GetEventByIdTask extends BaseTask <EventOutput> {
    Long id;
    public GetEventByIdTask(Context context, Long id, @Nullable ApiListener<EventOutput> listener) {
        super(context, listener);
        this.id = id;
    }

    @Override
    protected EventOutput callApiMethod() throws Exception {
        return mApi.getEventById(id);
    }
}
