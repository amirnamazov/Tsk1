package com.example.tsk1.services

import android.content.Context
import com.example.tsk1.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServicesFragmentModule {

    @Provides
    fun providesServicesAdapter(@ApplicationContext appContext: Context): ServicesAdapter {
        val list = listOf(
            Triple(R.drawable.ic_sheet, R.color.light_green, appContext.getString(R.string.ortalama_enerji_stehlak)),
            Triple(R.drawable.ic_sheet, R.color.light_green, appContext.getString(R.string.ortalama_enerji_stehlak)),
            Triple(R.drawable.ic_sheet, R.color.light_green, appContext.getString(R.string.ortalama_enerji_stehlak)),
        )
        return ServicesAdapter(list)
    }
}