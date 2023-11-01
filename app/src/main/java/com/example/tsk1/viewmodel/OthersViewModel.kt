package com.example.tsk1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tsk1.R

class OthersViewModel : ViewModel() {

    val listOthers: List<Pair<Int, String>> = listOf(
        Pair(R.drawable.ic_warning, "Təhlükəsizlik qaydaları"),
        Pair(R.drawable.ic_question, "Tez-tez verilən suallar"),
        Pair(R.drawable.ic_message, "Elektron Müraciət"),
        Pair(R.drawable.ic_location, "Regional ünvanlarımız"),
        Pair(R.drawable.ic_headphone, "Müştəri xidmətləri"),
        Pair(R.drawable.ic_tower, "Sərbəst güclər (info) "),
    )
}