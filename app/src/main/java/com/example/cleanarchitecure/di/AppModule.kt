package com.example.cleanarchitecure.di

import com.example.cleanarchitecure.common.Constants
import com.example.cleanarchitecure.data.remote.CoinPaprikaApi
import com.example.cleanarchitecure.data.repository.CoinRepositoryImpl
import com.example.cleanarchitecure.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


//determine how long these dependencies should live
@Module
// these live as long as our application.
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
fun providePaprikaApi() : CoinPaprikaApi{
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(CoinPaprikaApi::class.java)
}
    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi) :CoinRepository{
        return CoinRepositoryImpl(api)
    }
}