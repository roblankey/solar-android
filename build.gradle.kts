buildscript {
  repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
  }

  dependencies {
    classpath("com.android.tools.build:gradle:7.1.3")
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Constants.navigationVersion}")
    classpath("com.google.dagger:hilt-android-gradle-plugin:${Constants.hiltVersion}")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Constants.kotlinVersion}")

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}
