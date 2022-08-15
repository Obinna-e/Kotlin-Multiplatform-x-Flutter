import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'batterylevel_platform_interface.dart';

/// An implementation of [BatterylevelPlatform] that uses method channels.
class MethodChannelBatterylevel extends BatterylevelPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('batterylevel');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
