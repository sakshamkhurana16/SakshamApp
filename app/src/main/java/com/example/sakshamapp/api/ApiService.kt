package com.example.sakshamapp.api

import com.example.sakshamapp.dataclasses.DashboardResponse
import com.example.sakshamapp.dataclasses.LoginRequest
import com.example.sakshamapp.dataclasses.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/sydney/auth")
    fun login(@Body credentials: LoginRequest): Call<LoginResponse>

    @GET("/dashboard/{keypass}")
    fun getDashboardData(@Path("keypass") keypass: String): Call<DashboardResponse>
}
