package live.zj.apidemo.mvvm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class UserProfileViewModel(
    private val state: SavedStateHandle
) : ViewModel() {

    val userId: String = state["uid"] ?: throw java.lang.IllegalStateException("miss userID")


}