package com.filipau.exam.ui.startFragment

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.usecase.impl.GetPostsUseCase
import com.filipau.exam.Constants
import com.filipau.exam.Constants.ALL_POSTS_LIVE_DATA
import com.filipau.exam.base.mvvm.BaseViewModel
import com.filipau.exam.base.mvvm.failed
import com.filipau.exam.base.mvvm.next
import com.filipau.exam.base.mvvm.success
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.*

class StartViewModel(
    savedStateHandle: SavedStateHandle,
    private val mGetPostsUseCase: GetPostsUseCase

) : BaseViewModel(savedStateHandle) {

    val allPostsLiveData =
        savedStateHandle.getLiveData<Outcome<MutableList<PostItemDto>>>(
            ALL_POSTS_LIVE_DATA
        )

    fun getPostsFromApi() {
        mGetPostsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                allPostsLiveData.next(it)
            }, {
                allPostsLiveData.failed(it)
            }, {
                if (allPostsLiveData.value is Outcome.Next) {
                    allPostsLiveData.success((allPostsLiveData.value as Outcome.Next).data)
                }
            }).also { mCompositeDisposable.add(it) }
    }

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

            //Convert log to string
            val logString = log.toString()

            //Create txt file in SD Card
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
}