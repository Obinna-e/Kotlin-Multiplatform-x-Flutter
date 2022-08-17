package com.example.batterylevel.platform

import dev.buijs.klutter.annotations.kmp.*

class Platform {

  @AndroidContext
  @KlutterAdaptee(name = "getBatteryLevel")
  fun getBatteryLevel(context: Any): Double? {
    return BatteryLevel(context).level?.toDouble()
  }

}