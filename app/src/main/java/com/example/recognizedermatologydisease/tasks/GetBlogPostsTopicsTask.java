package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.BlogPostTopicsOutput;

public class GetBlogPostsTopicsTask extends BaseTask <BlogPostTopicsOutput> {
    int page,pagesize;
    public GetBlogPostsTopicsTask(Context context, int page, int pagesize, @Nullable ApiListener<BlogPostTopicsOutput> listener) {
        super(context, listener);
        this.page = page;
        this.pagesize = pagesize;
    }

    @Override
    protected BlogPostTopicsOutput callApiMethod() throws Exception {
        return mApi.getBlogPostsTopics(page,pagesize);
    }
}
