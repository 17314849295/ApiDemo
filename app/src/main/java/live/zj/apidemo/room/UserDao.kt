package live.zj.apidemo.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("select * from User")
    fun getAll(): List<User>
}