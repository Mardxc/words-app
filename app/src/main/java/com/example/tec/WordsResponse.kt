package com.example.tec

import com.google.gson.annotations.SerializedName

data class WordsResponse(
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<Datum>
)

data class Datum(
    @SerializedName("id") val id: Long,
    @SerializedName("palabra_es") val palabraEs: String,
    @SerializedName("palabra_xiu") val palabraXiu: String
)
