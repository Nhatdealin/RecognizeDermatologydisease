package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.EventsOutput;

public class GetEventsTask extends BaseTask <EventsOutput> {
    int page,pagesize;
    public GetEventsTask(Context context, int page, int pagesize, @Nullable ApiListener<EventsOutput> listener) {
        super(context, listener);
        this.page = page;
        this.pagesize = pagesize;
    }

    @Override
    protected EventsOutput  callApiMethod() throws Exception {
        return mApi.getEvents(page,pagesize);
    }
}
