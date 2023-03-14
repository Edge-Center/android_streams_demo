package ru.edgestreams.demo.model.data.remote

import android.content.Context
import androidx.fragment.app.FragmentActivity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.edgestreams.demo.EdgeApp
import ru.edgestreams.demo.R
import ru.edgestreams.demo.model.data.remote.auth.AuthRequestBody
import ru.edgestreams.demo.model.data.remote.auth.AuthResponse
import ru.edgestreams.demo.model.data.remote.refresh_token.RefreshRequestBody
import ru.edgestreams.demo.model.data.remote.streams.CreateStreamRequestBody
import ru.edgestreams.demo.model.data.remote.streams.StreamItemResponse
import ru.edgestreams.demo.model.data.remote.streams.StreamToBeCreated
import ru.edgestreams.demo.model.data.remote.streams.stream_detailed.StreamDetailedResponse

object RemoteAccessManager {

    const val EMAIL_KEY = "email"
    const val PASSWORD_KEY = "password"
    const val ACCESS_TOKEN_KEY = "accessToken"
    const val REFRESH_TOKEN_KEY = "refreshToken"

    private fun getAccessToken(fragmentActivity: FragmentActivity): String {
        return fragmentActivity.getSharedPreferences(
            fragmentActivity.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).getString(ACCESS_TOKEN_KEY, "") ?: ""
    }

    fun isAuth(fragmentActivity: FragmentActivity) = getAccessToken(
        fragmentActivity
    ).isNotEmpty()

    fun auth(
        fragmentActivity: FragmentActivity,
        requestBody: AuthRequestBody
    ): Single<AuthResponse> {

        return (fragmentActivity.application as EdgeApp).authApi.performLogin(requestBody)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun auth(fragmentActivity: FragmentActivity): Single<AuthResponse> {

        val eMail = fragmentActivity.getSharedPreferences(
            fragmentActivity.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).getString(EMAIL_KEY, "") ?: ""

        val password = fragmentActivity.getSharedPreferences(
            fragmentActivity.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).getString(PASSWORD_KEY, "") ?: ""

        val requestBody = AuthRequestBody(eMail = eMail, password = password)

        return (fragmentActivity.application as EdgeApp)
            .authApi
            .performLogin(requestBody)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun refreshAccessToken(fragmentActivity: FragmentActivity): Single<AuthResponse> {

        val refreshToken = fragmentActivity.getSharedPreferences(
            fragmentActivity.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).getString(REFRESH_TOKEN_KEY, "") ?: ""

        val requestBody = RefreshRequestBody(refreshAccessToken = refreshToken)

        return (fragmentActivity.application as EdgeApp)
            .refreshTokenApi
            .refreshToken(requestBody)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun loadStreamItems(
        fragmentActivity: FragmentActivity,
        page: Int
    ): Single<List<StreamItemResponse>> {
        val accessToken = getAccessToken(
            fragmentActivity
        )

        return (fragmentActivity.application as EdgeApp)
            .streamsApi
            .getStreams("Bearer $accessToken", page = page)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getStreamDetailed(
        fragmentActivity: FragmentActivity,
        streamId: Int
    ): Single<StreamDetailedResponse> {
        val accessToken = getAccessToken(
            fragmentActivity
        )

        return (fragmentActivity.application as EdgeApp)
            .streamsApi
            .getStreamDetailed("Bearer $accessToken", streamId)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun createStream(
        fragmentActivity: FragmentActivity,
        streamName: String
    ): Single<StreamItemResponse> {
        val accessToken = getAccessToken(
            fragmentActivity
        )
        val requestBody =
            CreateStreamRequestBody(stream = StreamToBeCreated(streamName = streamName))

        return (fragmentActivity.application as EdgeApp)
            .streamsApi
            .createStream("Bearer $accessToken", requestBody)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }
}