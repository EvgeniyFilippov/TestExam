package com.filipau.data.api

import com.filipau.data.NetConstants.API_PATH_VALUE_ID
import com.filipau.data.NetConstants.SERVER_POSTS
import com.filipau.data.NetConstants.SERVER_USERS
import com.filipau.data.model.post.PostItem
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {

    @GET(SERVER_POSTS)
    fun getListOfPosts(): Flowable<MutableList<PostItem>>

}