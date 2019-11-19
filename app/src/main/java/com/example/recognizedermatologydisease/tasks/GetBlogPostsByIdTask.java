package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.BlogPostOutput;

public class GetBlogPostsByIdTask extends BaseTask <BlogPostOutput> {
    Long id;
    public GetBlogPostsByIdTask(Context context, Long id, @Nullable ApiListener<BlogPostOutput> listener) {
        super(context, listener);
        this.id = id;
    }

    @Override
    protected BlogPostOutput callApiMethod() throws Exception {
        return mApi.getBlogPostById(id);
    }
}
