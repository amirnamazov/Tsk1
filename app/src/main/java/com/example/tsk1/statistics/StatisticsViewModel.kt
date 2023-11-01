package com.example.tsk1.statistics

import androidx.lifecycle.ViewModel
import com.example.tsk1.R

class StatisticsViewModel : ViewModel() {

    val list by lazy {
        listOf(
            "Yearly" to listOf(
                R.drawable.img_yearly_1 to "45",
                R.drawable.img_yearly_1 to "767",
            ),
            "Monthly" to listOf(
                R.drawable.img_month_1 to "12",
                R.drawable.img_monthly_2 to "23",
                R.drawable.img_yearly_1 to "98"
            )
        )
    }
}