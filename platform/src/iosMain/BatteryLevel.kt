package com.example.batterylevel.platform

import platform.UIKit.UIDevice

actual class BatteryLevel actual constructor(context: Any?) {

  actual val level: Float? = UIDevice.currentDevice.batteryLevel.let {
    if(it < 0) null else it * 100
  }

}