package com.kj_bagwatgeeta.model.resmodel


import com.google.gson.annotations.SerializedName

data class ChapterRes(
    @SerializedName("chapter_number")
    var chapterNumber: Int? = null,
    @SerializedName("chapter_summary")
    var chapterSummary: String? = null,
    @SerializedName("chapter_summary_hindi")
    var chapterSummaryHindi: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("name_meaning")
    var nameMeaning: String? = null,
    @SerializedName("name_translated")
    var nameTranslated: String? = null,
    @SerializedName("name_transliterated")
    var nameTransliterated: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("verses_count")
    var versesCount: Int? = null
)