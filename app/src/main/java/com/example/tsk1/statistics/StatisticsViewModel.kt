package com.example.tsk1.statistics

import androidx.lifecycle.ViewModel
import com.example.tsk1.R
import com.example.tsk1.model.Graph

class StatisticsViewModel : ViewModel() {

    val list by lazy {
        listOf(
            "Yearly" to listOf(
                R.drawable.img_yearly_1 + "182 kw",
                R.drawable.img_yearly_1 + "182 kw",
            ),
            "Monthly" to listOf(
                R.drawable.img_month_1 + "12 kw",
                R.drawable.img_monthly_2 + "23 kw",
                R.drawable.img_yearly_1 + "98 kw"
            )
        )
    }

    private operator fun Int.plus(title: String): Graph = Graph(this, title)
}