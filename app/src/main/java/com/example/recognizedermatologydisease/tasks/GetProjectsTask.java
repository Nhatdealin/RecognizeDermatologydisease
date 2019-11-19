package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.ProjectsOutput;

public class GetProjectsTask extends BaseTask <ProjectsOutput> {
    int page,pagesize;
    public GetProjectsTask(Context context,int page,int pagesize, @Nullable ApiListener<ProjectsOutput> listener) {
        super(context, listener);
        this.page = page;
        this.pagesize = pagesize;
    }

    @Override
    protected ProjectsOutput callApiMethod() throws Exception {
        return mApi.getProjects(page,pagesize);
    }
}
