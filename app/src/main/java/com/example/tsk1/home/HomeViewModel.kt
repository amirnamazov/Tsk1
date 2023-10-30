package com.example.tsk1.home

import androidx.lifecycle.ViewModel
import com.example.tsk1.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val listBanner: List<Triple<Int, Int, Int>> = listOf(
        Triple(R.string.ortalama_enerji_stehlak, R.color.light_green, R.drawable.ic_banner_1),
        Triple(R.string.add_auto_top_up, R.color.light_blue, R.drawable.ic_banner_2),
        Triple(R.string.enerjiy_q_na_t_m_sl_h_tl_ri, R.color.light_red, R.drawable.ic_banner_3),
    )

    val listNews: List<Pair<Int, Int>> = listOf(
        Pair(R.drawable.img_president, R.string.prezident_lham_liyev),
        Pair(R.drawable.img_labor, R.string.a_cab_dinin),
    )
}