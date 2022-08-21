package com.kj_bagwatgeeta.data.remote

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.kj_bagwatgeeta.utils.Config
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by Kamesh Singh.
 */

interface ApiClient {

    @POST("{apiName}")  // -- for postApi
    fun postApi(
        @Path("apiName") apiName: String,
        @Body reqJson: HashMap<String, Any?> = HashMap()
    ): Call<JsonObject>

    @GET("${Config.allChapters}?limit=18")
    fun getAllChapter(): Call<JsonArray>

    @GET("{id}/${Config.allVersesOfChapter}")
    fun getAllVersesOfChapter(@Path("id") id: Int): Call<JsonArray>

}