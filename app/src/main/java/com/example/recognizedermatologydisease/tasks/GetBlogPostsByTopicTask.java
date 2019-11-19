package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.BlogPostsOutput;

public class GetBlogPostsByTopicTask extends BaseTask <BlogPostsOutput> {
    int page,pagesize;
    Long idtopic;
    public GetBlogPostsByTopicTask(Context context,Long idtopic, int page, int pagesize, @Nullable ApiListener<BlogPostsOutput> listener) {
        super(context, listener);
        this.page = page;
        this.pagesize = pagesize;
        this.idtopic = idtopic;
    }

    @Override
    protected BlogPostsOutput callApiMethod() throws Exception {
        return mApi.getBlogPostsByIdTopic(idtopic,page,pagesize);
    }
}
