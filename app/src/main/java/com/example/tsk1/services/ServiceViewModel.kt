package com.example.tsk1.services

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import com.example.tsk1.R
import com.example.tsk1.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    val list = listOf(
        getTriple(R.drawable.ic_bag, R.string.qo_ulma),
        getTriple(R.drawable.ic_sheet, R.string.hali_abonentinin),
        getTriple(R.drawable.ic_operator, R.string.kalkulyatorlar),
        getTriple(R.drawable.ic_printer, R.string.borcun_ara),
        getTriple(R.drawable.ic_refresh, R.string.abonentin),
        getTriple(R.drawable.ic_bag, R.string.qo_ulma),
        getTriple(R.drawable.ic_sheet, R.string.hali_abonentinin),
        getTriple(R.drawable.ic_operator, R.string.kalkulyatorlar),
        getTriple(R.drawable.ic_printer, R.string.borcun_ara),
        getTriple(R.drawable.ic_refresh, R.string.abonentin),
    )

    private fun getTriple(drawableId: Int, stringId: Int): Triple<Int, Int, String> {
        val dominantColor = ContextCompat.getColor(context, R.color.light_green)
        val bitmap = ContextCompat.getDrawable(context, drawableId)!!.toBitmap()
        val color = Palette.from(bitmap).generate().getDominantColor(dominantColor)
        val title = context.getString(stringId)

        return Triple(drawableId, color, title)
    }
}