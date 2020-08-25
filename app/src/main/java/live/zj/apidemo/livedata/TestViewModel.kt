package live.zj.apidemo.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    val number = MutableLiveData<Int>()
}