package ru.edgestreams.demo.model.data.remote.streams.stream_detailed

import com.google.gson.annotations.SerializedName

data class StreamDetailedResponse(
    @SerializedName("id") val streamId: Int,
    @SerializedName("live") val streamLive: Boolean,
    @SerializedName("backup_live") val streamBackupLive: Boolean,
    @SerializedName("name") val streamName: String,
    @SerializedName("client_id") val clientId: Int,
    @SerializedName("transcoded_qualities") val streamTranscodedQualities: List<String>,
    @SerializedName("push_url") val streamPushUrl: String,
    @SerializedName("backup_push_url") val streamBackupPushUrl: String,
    @SerializedName("push_url_srt") val streamPushUrlSrt: String?,
    @SerializedName("backup_push_url_srt") val streamBackupPushUrlSrt: String?,
    @SerializedName("transcoding_speed") val streamTranscodingSpeed: Double?,
    @SerializedName("transcoding_error") val streamTranscodingError: String?,
    @SerializedName("receiving_speed") val streamReceivingSpeed: Double?,
    @SerializedName("receiving_error") val streamReceivingError: String?,
    @SerializedName("broadcast_ids") val streamBroadcastIds: List<Int>,
    @SerializedName("pull") val streamPull: Boolean,
    @SerializedName("token") val streamToken: String,
    @SerializedName("active") val streamActive: Boolean,
    @SerializedName("auto_record") val streamAutoRecord: Boolean?,
    @SerializedName("webrtc") val streamWebrtc: Boolean,
    @SerializedName("uri") val streamUri: String?,
    @SerializedName("dvr_enabled") val streamDvrEnabled: Boolean,
    @SerializedName("cdn_id") val streamCdnId: Int?,
    @SerializedName("client_user_id") val clientUserId: Int?,
    @SerializedName("quality_set_id") val streamQualitySetId: Int?,
    @SerializedName("rtmp_play_url") val streamRtmpPlayUrl: List<String>,
    @SerializedName("transcoding_enabled") val streamTranscodingEnabled: Boolean,
    @SerializedName("projection") val streamProjection: String,
    @SerializedName("low_latency_enabled") val streamLowLatencyEnabled: Boolean,
    @SerializedName("protocol") val streamProtocol: Any?,
    @SerializedName("recording") val streamRecording: Boolean,
    @SerializedName("recording_duration") val streamRecordingDuration: Long?,
    @SerializedName("quality_sets") val streamQualitySets: List<StreamQualitySet>,
    @SerializedName("cdn_hostname") val cdnHostname: String?,
    @SerializedName("broadcasts") val streamBroadcasts: List<Broadcast>,
    @SerializedName("restreams") val streamRestreams: List<Any?>,
    @SerializedName("logo_player_id") val logoPlayerId: Int?,
    @SerializedName("overlay") val streamOverlay: Any?,
    @SerializedName("iframe_url") val streamIframeUrl: String,
    @SerializedName("dvr_duration") val streamDvrDuration: Int?,
    @SerializedName("frame_rate") val streamFrameRate: Double?,
    @SerializedName("video_bitrate") val streamVideoBitrate: String?,
    @SerializedName("audio_bitrate") val streamAudioBitrate: String?,
    @SerializedName("video_height") val streamVideoHeight: Int?,
    @SerializedName("video_width") val streamVideoWidth: Int?,
    @SerializedName("audio_channels") val streamAudioChannels: Int?,
    @SerializedName("audio_codec") val streamAudioCodec: String?,
    @SerializedName("audio_sample_rate") val streamAudioSampleRate: Int?,
    @SerializedName("hls_playlist_url") val streamHlsPlaylistUrl: String
)