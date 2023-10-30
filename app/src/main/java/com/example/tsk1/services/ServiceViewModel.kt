package com.example.tsk1.services

import androidx.lifecycle.ViewModel
import com.example.tsk1.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor() : ViewModel() {

    val list: List<Pair<Int, Int>> = listOf(
        Pair(R.drawable.ic_bag, R.string.qo_ulma),
        Pair(R.drawable.ic_sheet, R.string.hali_abonentinin),
        Pair(R.drawable.ic_operator, R.string.kalkulyatorlar),
        Pair(R.drawable.ic_printer, R.string.borcun_ara),
        Pair(R.drawable.ic_refresh, R.string.abonentin),
        Pair(R.drawable.ic_bag, R.string.qo_ulma),
        Pair(R.drawable.ic_sheet, R.string.hali_abonentinin),
        Pair(R.drawable.ic_operator, R.string.kalkulyatorlar),
        Pair(R.drawable.ic_printer, R.string.borcun_ara),
        Pair(R.drawable.ic_refresh, R.string.abonentin),
    )
}