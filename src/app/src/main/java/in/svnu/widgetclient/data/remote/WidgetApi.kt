package `in`.svnu.widgetclient.data.remote

import `in`.svnu.widgetclient.data.remote.dto.CreateWidgetRequest
import `in`.svnu.widgetclient.data.remote.dto.ShareWidgetRequest
import `in`.svnu.widgetclient.data.remote.dto.UpdateWidgetRequest
import `in`.svnu.widgetclient.data.remote.dto.WidgetResponse
import `in`.svnu.widgetclient.data.remote.dto.WidgetStateResponse
import `in`.svnu.widgetclient.data.remote.dto.WidgetsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * Retrofit API interface for widget CRUD and state endpoints.
 *
 * All endpoints require JWT (attached by AuthInterceptor).
 */
interface WidgetApi {

    @GET("api/widgets")
    suspend fun getWidgets(): Response<WidgetsResponse>

    @POST("api/widgets")
    suspend fun createWidget(@Body request: CreateWidgetRequest): Response<WidgetResponse>

    @PUT("api/widgets/{id}")
    suspend fun updateWidget(
        @Path("id") id: String,
        @Body request: UpdateWidgetRequest,
    ): Response<WidgetResponse>

    @DELETE("api/widgets/{id}")
    suspend fun deleteWidget(@Path("id") id: String): Response<Unit>

    @PUT("api/widgets/{id}/share")
    suspend fun shareWidget(
        @Path("id") id: String,
        @Body request: ShareWidgetRequest,
    ): Response<WidgetResponse>

    @GET("api/widgets/{id}/state")
    suspend fun getWidgetState(@Path("id") id: String): Response<WidgetStateResponse>
}
