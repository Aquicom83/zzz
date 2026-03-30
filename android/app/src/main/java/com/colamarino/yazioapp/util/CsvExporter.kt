
package com.colamarino.yazioapp.util

import android.content.Context
import java.io.File

object CsvExporter {
    fun export(context: Context, headers: List<String>, rows: List<List<String>>, fileName: String = "yazio_export.csv"): File {
        val file = File(context.getExternalFilesDir(null), fileName)
        file.printWriter().use { out ->
            out.println(headers.joinToString(","))
            rows.forEach { out.println(it.joinToString(",")) }
        }
        return file
    }
}
