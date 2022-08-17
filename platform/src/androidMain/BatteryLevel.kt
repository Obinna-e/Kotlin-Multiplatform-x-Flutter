package com.example.batterylevel.platform

import android.content.Context
import android.os.BatteryManager

actual class BatteryLevel actual constructor(context: Any?) {

  actual val level: Float? = context?.let {
    getBatteryLevel(context as Context).toFloat()
  }

  private fun getBatteryLevel(context: Context): Int {
    val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
    return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
  }

}