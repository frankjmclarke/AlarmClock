package com.fclarke.alarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class myBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent!!.action.equals("com.tester.alarmmanager")){
            var b=intent.extras
           // Toast.makeText(context,b.getString("message"),Toast.LENGTH_LONG).show()
            val notifyMe=Notifications()
            notifyMe.notify(context!!, b!!.getString("message")!!,10)
        }
        else if(intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){

            val saveData=SaveData(context!!)
            saveData.setAlarm()
        }
    }

}
