package com.example.tsk1.home

import android.app.Application
import com.example.tsk1.R
import com.example.tsk1.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    val listBanner = listOf(
        Triple(context.getString(R.string.ortalama_enerji_stehlak), R.color.light_green, R.drawable.ic_banner_1),
        Triple(context.getString(R.string.add_auto_top_up), R.color.light_blue, R.drawable.ic_banner_2),
        Triple(context.getString(R.string.enerjiy_q_na_t_m_sl_h_tl_ri), R.color.light_red, R.drawable.ic_banner_3),
    )

    val listNews = listOf(
        Pair(R.drawable.img_president, context.getString(R.string.prezident_lham_liyev)),
        Pair(R.drawable.img_labor, context.getString(R.string.a_cab_dinin)),
    )
}