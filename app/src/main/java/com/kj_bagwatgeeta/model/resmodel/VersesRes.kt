package com.kj_bagwatgeeta.model.resmodel


import com.google.gson.annotations.SerializedName

data class VersesRes(
    @SerializedName("chapter_number")
    var chapterNumber: Int? = null,
    @SerializedName("commentaries")
    var commentaries: MutableList<Commentary?>? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("text")
    var text: String? = null,
    @SerializedName("translations")
    var translations: MutableList<Translation?>? = null,
    @SerializedName("transliteration")
    var transliteration: String? = null,
    @SerializedName("verse_number")
    var verseNumber: Int? = null,
    @SerializedName("word_meanings")
    var wordMeanings: String? = null
) {
    data class Commentary(
        @SerializedName("author_name")
        var authorName: String? = null,
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("language")
        var language: String? = null
    )

    data class Translation(
        @SerializedName("author_name")
        var authorName: String? = null,
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("language")
        var language: String? = null
    )
}