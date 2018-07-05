package cubex.mahesh.brtest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        var tview:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            tview = textView
            var iFilter = IntentFilter( )
            iFilter.addAction(Intent.ACTION_HEADSET_PLUG)
            iFilter.addAction(Intent.ACTION_POWER_CONNECTED)
            iFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
            iFilter.addAction(Intent.ACTION_SCREEN_ON)
            iFilter.addAction(Intent.ACTION_SCREEN_OFF)
            iFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            registerReceiver(MyReceiver(tview!!),iFilter)
    }

    class MyReceiver(var tview:TextView):BroadcastReceiver()
    {
        override fun onReceive(p0: Context?, p1: Intent?) {
                tview.text = p1!!.action
        }
    }


}
