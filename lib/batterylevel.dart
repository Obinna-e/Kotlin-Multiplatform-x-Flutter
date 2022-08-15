
import 'batterylevel_platform_interface.dart';

class Batterylevel {
  Future<String?> getPlatformVersion() {
    return BatterylevelPlatform.instance.getPlatformVersion();
  }
}
