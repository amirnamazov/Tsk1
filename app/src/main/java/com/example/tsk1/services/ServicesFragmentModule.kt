package com.example.tsk1.services

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import com.example.tsk1.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServicesFragmentModule {

    private fun Context.getTriple(drawableId: Int, stringId: Int):
            Triple<Int, Int, String> {
        val dominantColor = ContextCompat.getColor(this, R.color.light_green)
        val bitmap = ContextCompat.getDrawable(this, drawableId)!!.toBitmap()
        val color = Palette.from(bitmap).generate().getDominantColor(dominantColor)
        val title = getString(stringId)

        return Triple(drawableId, color, title)
    }

    @Provides
    fun providesServicesAdapter(@ApplicationContext appContext: Context): ServicesAdapter {

        val list = listOf(
            appContext.getTriple(R.drawable.ic_bag, R.string.qo_ulma),
            appContext.getTriple(R.drawable.ic_sheet, R.string.hali_abonentinin),
            appContext.getTriple(R.drawable.ic_operator, R.string.kalkulyatorlar),
            appContext.getTriple(R.drawable.ic_printer, R.string.borcun_ara),
            appContext.getTriple(R.drawable.ic_refresh, R.string.abonentin),
            appContext.getTriple(R.drawable.ic_bag, R.string.qo_ulma),
            appContext.getTriple(R.drawable.ic_sheet, R.string.hali_abonentinin),
            appContext.getTriple(R.drawable.ic_operator, R.string.kalkulyatorlar),
            appContext.getTriple(R.drawable.ic_printer, R.string.borcun_ara),
            appContext.getTriple(R.drawable.ic_refresh, R.string.abonentin),
        )
        return ServicesAdapter(list)
    }
}