package com.blydenburgh.kgraphqldemo

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.RuntimeException

@Component
abstract class CSVDataImporter {

    abstract fun import()

    fun String.toDoubleOrZero() = toDoubleOrNull() ?: 0.0

    fun String.toIntOrZero() = toIntOrNull() ?: 0

    fun importFromCsv(inputStream: InputStream, consumer: (Array<String>) -> Unit) {
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))

        try {
            return bufferedReader.useLines { lines ->
                lines.drop(1).forEach { line ->
                    consumer(line.split("\\t".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
                }
            }
        } catch (ex: Exception) {
            throw RuntimeException("Failed to perform input due to [$ex]")
        }
    }
}