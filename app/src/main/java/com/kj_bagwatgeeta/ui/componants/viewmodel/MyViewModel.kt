package com.kj_bagwatgeeta.ui.componants.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.kj_bagwatgeeta.data.remote.Repository
import com.kj_bagwatgeeta.model.User
import com.kj_bagwatgeeta.model.resmodel.ChapterRes
import com.kj_bagwatgeeta.model.resmodel.VersesRes


class MyViewModel : ViewModel() {
    var allChapters = mutableStateListOf<ChapterRes>()
    var allVerses = mutableStateListOf<VersesRes>()
    private val repository by lazy { Repository() }
    val showLoader = mutableStateOf(false)

    init {

    }

    fun getAllChapter(context: Context) {
        showLoader.value = true
        repository.callApiGetAllChapters()?.observe(context as LifecycleOwner, Observer {
            showLoader.value = false
            if (it != null) {
                allChapters.clear()
                allChapters.addAll(convertChaptersTList(it))
                Log.d("response", "______________${allChapters.size}")
            }
        })
    }


    fun getAllVersesOfChapter(context: Context,chapterId:Int) {
        allVerses.clear()
        showLoader.value = true
        repository.callApiGetAllVersesOfChapters(chapterId)?.observe(context as LifecycleOwner, Observer {
            showLoader.value = false
            if (it != null) {
                allVerses.addAll(convertVersesList(it))

                Log.d("response", "______________${ allVerses.size}")
            }
        })
    }


    private fun convertChaptersTList(json: JsonArray): MutableList<ChapterRes> {
        val gson = Gson()
        var allChapterList = mutableListOf<ChapterRes>()
        val type = object : TypeToken<MutableList<ChapterRes>>() {}.type
        allChapterList = try {
            gson.fromJson(json, type)
        } catch (ex: Exception) {
            mutableListOf<ChapterRes>()
        }
        return allChapterList
    }

    private fun convertVersesList(json: JsonArray): MutableList<VersesRes> {
        val gson = Gson()
        var allVersesResList = mutableListOf<VersesRes>()
        val type = object : TypeToken<MutableList<VersesRes>>() {}.type
        allVersesResList = try {
            gson.fromJson(json, type)
        } catch (ex: Exception) {
            mutableListOf<VersesRes>()
        }
        return allVersesResList
    }
}