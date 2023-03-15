package ru.edgestreams.demo.model.data.remote.streams.stream_detailed

import com.google.gson.annotations.SerializedName

data class StreamQuality(
    @SerializedName("height") val streamHeight: Int?,
    @SerializedName("url") val streamUrl: String?
)