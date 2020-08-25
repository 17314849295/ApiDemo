package live.zj.apidemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*
import live.zj.apidemo.livedata.TestViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TestViewModel by viewModels()

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.number.observe(this) {
            number.text = it.toString()
        }

        add.setOnClickListener {
            viewModel.number.value = i++
        }
    }
}