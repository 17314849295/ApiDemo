package live.zj.apidemo

import android.util.Log

const val TAG = "测试日志"
fun Any.log() {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, this.toString())
    }
}