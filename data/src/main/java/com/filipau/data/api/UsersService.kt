package com.filipau.data.api

import com.filipau.data.NetConstants.API_PATH_VALUE_ID
import com.filipau.data.NetConstants.SERVER_USERS
import com.filipau.data.model.user.User
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {

    @GET(SERVER_USERS)
    fun getListOfUsers(
        @Path(API_PATH_VALUE_ID) id: String
    ): Flow<User>

}