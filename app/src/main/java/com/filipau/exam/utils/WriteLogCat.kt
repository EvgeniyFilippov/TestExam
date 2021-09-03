package com.filipau.exam.utils

import android.content.Context
import com.filipau.exam.Constants
import java.io.*

fun writeLogCat(context: Context) {
    var fout: FileOutputStream? = null
    var osw: OutputStreamWriter? = null
    try {
        val process = Runtime.getRuntime().exec("logcat -d")
        val bufferedReader = BufferedReader(InputStreamReader(process.inputStream))
        val log = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            log.append(line)
            log.append("\n")
        }

        val logString = log.toString()

        val filesDir: File? = context.filesDir
        val dir = File(filesDir?.absolutePath + File.separator + Constants.LOG_DIR)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val file = File(dir, Constants.LOGCAT_FILE)

        //To write logcat in text file
        fout = FileOutputStream(file)
        osw = OutputStreamWriter(fout)

        //Writing the string to file
        osw.write(logString)
        osw.flush()
        osw.close()
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        try {
            osw?.close()
            fout?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}