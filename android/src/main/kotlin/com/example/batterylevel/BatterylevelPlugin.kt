package com.example.batterylevel

import dev.buijs.klutter.template.Greeting
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/** BatterylevelPlugin */
class BatterylevelPlugin: FlutterPlugin, MethodCallHandler {
  // The MethodChannel that will the communication between Flutter and native Android
  //
  // This local reference serves to register the plugin with the Flutter Engine and unregister it
  // when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel

  private val mainScope = CoroutineScope(Dispatchers.Main)

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "batterylevel")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        mainScope.launch {
         when (call.method) {
           "greeting" -> {
             result.success(Greeting().greeting())
           }
           else -> result.notImplemented()
           }
        }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}