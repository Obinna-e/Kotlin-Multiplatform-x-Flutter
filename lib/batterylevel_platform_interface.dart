import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'batterylevel_method_channel.dart';

abstract class BatterylevelPlatform extends PlatformInterface {
  /// Constructs a BatterylevelPlatform.
  BatterylevelPlatform() : super(token: _token);

  static final Object _token = Object();

  static BatterylevelPlatform _instance = MethodChannelBatterylevel();

  /// The default instance of [BatterylevelPlatform] to use.
  ///
  /// Defaults to [MethodChannelBatterylevel].
  static BatterylevelPlatform get instance => _instance;
  
  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [BatterylevelPlatform] when
  /// they register themselves.
  static set instance(BatterylevelPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
