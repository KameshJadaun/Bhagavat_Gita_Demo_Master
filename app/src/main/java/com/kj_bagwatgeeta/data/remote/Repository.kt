package com.kj_bagwatgeeta.data.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {
    private var apiClient: ApiClient = ServiceGenerator.getInstanse().clientService

    //----------------Post method with params----------------------------


    fun callApiGetAllChapters(): MutableLiveData<JsonArray?>? {
        val jsnRes = MutableLiveData<JsonArray?>()
        apiClient.getAllChapter().enqueue(object : Callback<JsonArray> {
                override fun onResponse(
                    call: Call<JsonArray>,
                    response: Response<JsonArray>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        jsnRes.value = response.body()
                    } else {
                        jsnRes.value = null
                    }
                    Log.d("response___api", "____________________${jsnRes.value}")
                }

                override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                    jsnRes.value = null
                }
            })
        return jsnRes

    }

    fun callApiGetAllVersesOfChapters(id:Int): MutableLiveData<JsonArray?>? {
        val jsnRes = MutableLiveData<JsonArray?>()
        apiClient.getAllVersesOfChapter(id).enqueue(object : Callback<JsonArray> {
            override fun onResponse(
                call: Call<JsonArray>,
                response: Response<JsonArray>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    jsnRes.value = response.body()
                } else {
                    jsnRes.value = null
                }
                Log.d("response___api", "____________________${jsnRes.value}")
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                jsnRes.value = null
            }
        })
        return jsnRes

    }


    //----------------Post method with params----------------------------

    //--------CommonMethod----------------------------
    fun validateResponse(
        response: Response<JsonObject>
    ): JsonObject? {
        val jsnRes = MutableLiveData<JsonObject?>()
        if (response.isSuccessful) {
            if (response.body() != null) {
                if ((response.body()!!.get("code") != null && response.body()!!
                        .get("code").asInt == 0 && response.body()!!.get("data") != null)
                ) {
                    jsnRes.value = response.body()
                } else {
                    /* Utility.showErrorDialog(
                         context,
                         "${response.body()!!.get("status")}",
                         "${response.body()!!.get("message")}"
                     )*/
                    jsnRes.value = null
                }
            } else {
                /*Utility.showErrorDialog(
                    context,
                    "Error",
                    context.getString(R.string.something_went_wrong)
                )*/

                jsnRes.value = null
            }
        } else {
            /*Utility.showErrorResponse(
                context,
                response.errorBody(),
                response.raw()
            )*/
            jsnRes.value = null
        }
        // Utility.hideLoder()
        return jsnRes.value
    }


}