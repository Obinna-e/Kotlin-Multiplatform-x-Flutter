import 'package:flutter/material.dart';
import 'dart:async';

import 'package:batterylevel/batterylevel.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    // Klutter generated Adapters don't throw exceptions but always return a
    // response object. No need for try-catch here. Do or do not. There is no try.
    await Batterylevel.greeting.then((response) {
      String platformVersion = response.isSuccess()
          ? response.object
          : response.exception.toString();

      // If the widget was removed from the tree while the asynchronous platform
      // message was in flight, we want to discard the reply rather than calling
      // setState to update our non-existent appearance.
      if (!mounted) return;

     setState(() {
        _platformVersion = platformVersion;
     });
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_platformVersion'),
        ),
      ),
    );
  }
}