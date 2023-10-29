package com.example.tsk1.home

import android.content.Context
import com.example.tsk1.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeFragmentModule {

    @Provides
    fun providesBanners(@ApplicationContext appContext: Context): BannerAdapter {
        val list = listOf(
            Triple(appContext.getString(R.string.ortalama_enerji_stehlak), R.color.light_green, R.drawable.ic_banner_1),
            Triple(appContext.getString(R.string.add_auto_top_up), R.color.light_blue, R.drawable.ic_banner_2),
            Triple(appContext.getString(R.string.enerjiy_q_na_t_m_sl_h_tl_ri), R.color.light_red, R.drawable.ic_banner_3),
        )
        return BannerAdapter(list)
    }

    @Provides
    fun providesNewsAdapter(@ApplicationContext appContext: Context): NewsAdapter {
        val list = listOf(
            Pair(R.drawable.img_president, appContext.getString(R.string.prezident_lham_liyev)),
            Pair(R.drawable.img_labor, appContext.getString(R.string.a_cab_dinin)),
        )
        return NewsAdapter(list)
    }
}