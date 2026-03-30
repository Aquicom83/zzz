
package com.colamarino.yazioapp.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.colamarino.yazioapp.ui.components.LineChartView
import com.colamarino.yazioapp.ui.components.TimeRange
import com.colamarino.yazioapp.ui.components.TimeRangePicker
import com.colamarino.yazioapp.util.CsvExporter
import com.github.mikephil.charting.data.Entry
import java.io.File

@Composable
fun DashboardScreen(){
    var range by remember { mutableStateOf(TimeRange.WEEK) }
    val entries = remember(range){
        (0..6).map { i -> Entry(i.toFloat(), (1500 + i*50).toFloat()) }
    }
    val ctx = LocalContext.current

    Column(Modifier.fillMaxSize().padding(16.dp)){
        Text("Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        TimeRangePicker(selected = range, onSelect = { range = it })
        Spacer(Modifier.height(8.dp))
        LineChartView(entries, label = "Calorie")
        Spacer(Modifier.height(12.dp))
        Button(onClick = {
            val headers = listOf("x","calories")
            val rows = entries.map { listOf(it.x.toString(), it.y.toString()) }
            val f: File = CsvExporter.export(ctx, headers, rows, "yazio_export.csv")
            val uri = FileProvider.getUriForFile(ctx, ctx.packageName + ".fileprovider", f)
            val share = Intent(Intent.ACTION_SEND).apply {
                type = "text/csv"
                putExtra(Intent.EXTRA_STREAM, uri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            ctx.startActivity(Intent.createChooser(share, "Condividi CSV"))
        }){
            Text("Esporta CSV")
        }
    }
}
