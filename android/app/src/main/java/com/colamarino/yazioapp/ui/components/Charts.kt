
package com.colamarino.yazioapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun LineChartView(entries: List<Entry>, label: String){
    AndroidView(factory = { context ->
        LineChart(context).apply {
            val dataSet = LineDataSet(entries, label)
            this.data = LineData(dataSet)
        }
    }, update = { chart ->
        val dataSet = LineDataSet(entries, label)
        chart.data = LineData(dataSet)
        chart.invalidate()
    })
}
