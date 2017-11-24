package izijia.ccpress.com.jpushdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

/**
 * Created by Admin on 2017/11/22.
 */
class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var red = findViewById(R.id.red) as TextView
        red.setOnClickListener { view: View? ->
            run {
                println("sdfsdf")
                println("sdfsdf")
            }
        }

    }
}