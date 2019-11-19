package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.SignupOutput;
import com.example.recognizedermatologydisease.api.objects.VolunteerInput;

public class SignupVolunteerTask extends BaseTask <SignupOutput> {
    VolunteerInput volunteerInput;
    Long eventId;
    public SignupVolunteerTask(Context context, VolunteerInput volunteerInput,Long eventId, @Nullable ApiListener<SignupOutput> listener) {
        super(context, listener);
        this.volunteerInput = volunteerInput ;
        this.eventId = eventId;

    }

    @Override
    protected SignupOutput callApiMethod() throws Exception {
        return mApi.signUpVolunteer(volunteerInput,eventId);
    }
}
