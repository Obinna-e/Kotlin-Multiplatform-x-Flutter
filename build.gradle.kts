buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://repsy.io/mvn/buijs-dev/klutter") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("dev.buijs.klutter:core:2022.r6-7.alpha")
        classpath("dev.buijs.klutter.gradle:dev.buijs.klutter.gradle.gradle.plugin:2022.r6-7.alpha")
    }
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://repsy.io/mvn/buijs-dev/klutter") }
}

allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://repsy.io/mvn/buijs-dev/klutter")
        }
    }

}

tasks.register("klutterInstallPlatform", Exec::class) {
    commandLine("bash", "./gradlew", "clean", "build", "-p", "platform")
    finalizedBy("klutterCopyAarFile", "klutterCopyFramework")
}

tasks.register("klutterCopyAarFile", Copy::class) {
    from("platform/build/outputs/aar/batterylevel-release.aar")
    into("android/klutter")
    rename { fileName ->
        fileName.replace("batterylevel-release", "platform")
    }
}

tasks.register("klutterCopyFramework", Copy::class) {
    from("platform/build/fat-framework/release")
    into("ios/Klutter")
}