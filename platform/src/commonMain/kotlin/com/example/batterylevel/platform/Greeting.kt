package com.example.batterylevel.platform

import dev.buijs.klutter.annotations.kmp.KlutterAdaptee

class Greeting {

    @KlutterAdaptee(name = "greeting")
    fun greeting(): String {
       return "Hello, ${Platform().platform}!"
    }

}