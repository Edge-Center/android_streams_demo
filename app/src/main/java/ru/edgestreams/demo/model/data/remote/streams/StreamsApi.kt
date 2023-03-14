package ru.edgestreams.demo.model.data.remote.streams

import io.reactivex.Single
import retrofit2.http.*
import ru.edgestreams.demo.model.data.remote.streams.stream_detailed.StreamDetailedResponse

interface StreamsApi {

    /**
     * @param page integer; Query parameter. Use it to list the paginated content
     * @param withBroadcasts integer; Query parameter.
     * Set to 1 to get details of the broadcasts associated with the stream
     */
    @GET("./streaming/streams")
    fun getStreams(
        @Header("Authorization") accessToken: String,
        @Query("page") page: Int,
        @Query("with_broadcasts") withBroadcasts: Int = 1
    ): Single<List<StreamItemResponse>>

    @GET("/streaming/streams/{stream_id}")
    fun getStreamDetailed(
        @Header("Authorization") accessToken: String,
        @Path("stream_id") streamId: Int
    ): Single<StreamDetailedResponse>

    @POST("./streaming/streams")
    fun createStream(
        @Header("Authorization") accessToken: String,
        @Body body: CreateStreamRequestBody
    ): Single<StreamItemResponse>
}