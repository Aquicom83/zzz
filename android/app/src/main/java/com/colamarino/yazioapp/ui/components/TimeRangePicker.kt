
package com.colamarino.yazioapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.colamarino.yazioapp.util.TimeRange

@Composable
fun TimeRangePicker(selected: TimeRange, onSelect: (TimeRange)->Unit){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        listOf(TimeRange.DAY, TimeRange.WEEK, TimeRange.MONTH, TimeRange.YEAR).forEach { r ->
            Button(onClick = { onSelect(r) }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text(r.name)
            }
        }
    }
}
