package com.hfad.tasks.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "http://sandipbgt.com"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface TaskApiService{

    @GET("theastrologer/api/horoscope/{sign}/today/")
    suspend fun getSign(@Path("sign") sign: Long?)


}

object TaskApi{
    val retrofitService : TaskApiService by lazy {
        retrofit.create(TaskApiService::class.java)
    }
}