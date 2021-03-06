package cz.covid19cz.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import cz.covid19cz.app.db.SharedPrefsRepository
import cz.covid19cz.app.service.CovidService
import org.koin.core.KoinComponent
import org.koin.core.inject

class OnBootReceiver : BroadcastReceiver(), KoinComponent {

    private val prefs by inject<SharedPrefsRepository>()

    override fun onReceive(context: Context, intent: Intent) {
        if (prefs.getDeviceBuid() != null && !prefs.getAppPaused()){
            ContextCompat.startForegroundService(context, CovidService.startService(context))
        }
    }
}