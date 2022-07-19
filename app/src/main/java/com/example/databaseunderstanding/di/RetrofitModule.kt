package com.example.databaseunderstanding.di

import com.example.databaseunderstanding.retrofit.fixture.FixtrueRetrofitCall
import com.example.databaseunderstanding.retrofit.league.LeagueRetrofitCall
import com.example.databaseunderstanding.retrofit.teams.TeamsRetrofitCall
import com.example.databaseunderstanding.retrofit.timezone.TimeZoneRetrofitCall
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson): Retrofit.Builder {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())

    }

    @Singleton
    @Provides
    fun providesFixtureService(retrofit: Retrofit.Builder): FixtrueRetrofitCall {
        return retrofit.build().create(FixtrueRetrofitCall::class.java)
    }

    @Singleton
    @Provides
    fun providesTimeZoneService(retrofit: Retrofit.Builder): TimeZoneRetrofitCall {
        return retrofit.build().create(TimeZoneRetrofitCall::class.java)
    }

    @Singleton
    @Provides
    fun providesLeagueService(retrofit: Retrofit.Builder): LeagueRetrofitCall {
        return retrofit.build().create(LeagueRetrofitCall::class.java)
    }

    @Singleton
    @Provides
    fun provideTeamService(retrofit: Retrofit.Builder): TeamsRetrofitCall {
        return retrofit.build().create(TeamsRetrofitCall::class.java)
    }


}