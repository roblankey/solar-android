import io.gitlab.arturbosch.detekt.Detekt

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("androidx.navigation.safeargs.kotlin")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
  id("io.gitlab.arturbosch.detekt") version(Constants.detektVersion)
}

android {
  compileSdk = Constants.compileSdkVersion
  defaultConfig {
    applicationId = "com.rl.solar"
    minSdk = Constants.minSdkVersion
    targetSdk = Constants.targetSdkVersion
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "com.rl.solar.HiltTestRunner"
    proguardFiles

    javaCompileOptions {
      annotationProcessorOptions {
        arguments += mapOf(
          "room.schemaLocation" to "$projectDir/schemas",
          "room.incremental" to "true",
          "room.expandProjection" to "true"
        )
      }
    }
  }

  buildTypes {
    debug {
      isDebuggable = true
    }
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    dataBinding = true
    viewBinding = true
  }

  testOptions.unitTests {
    isIncludeAndroidResources = true
    isReturnDefaultValues = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions.jvmTarget = "1.8"
}

kapt {
  arguments {
    // Make Hilt share the same definition of Components in tests instead of
    // creating a new set of Components per test class.
    arg("dagger.hilt.shareTestComponents", "true")
  }
}

dependencies {
  // Architecture Components
  implementation("androidx.appcompat:appcompat:${Constants.appCompatVersion}")
  implementation("androidx.constraintlayout:constraintlayout:${Constants.constraintLayoutVersion}")
  implementation("androidx.core:core-ktx:${Constants.androidCoreKtxVersion}")
  implementation("androidx.fragment:fragment-ktx:${Constants.fragmentKtxVersion}")
  implementation("androidx.legacy:legacy-support-v4:${Constants.androidXLegacySupportVersion}")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Constants.archLifecycleVersion}")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Constants.archLifecycleVersion}")
  implementation("androidx.navigation:navigation-fragment-ktx:${Constants.navigationVersion}")
  implementation("androidx.navigation:navigation-ui-ktx:${Constants.navigationVersion}")

  // App dependencies
  implementation("com.github.bumptech.glide:glide:${Constants.glideVersion}")
  kapt("com.github.bumptech.glide:compiler:${Constants.glideVersion}")
  implementation("com.google.android.material:material:${Constants.materialVersion}")
  implementation("com.jakewharton.timber:timber:${Constants.timberVersion}")

  // Hilt
  implementation("com.google.dagger:hilt-android:${Constants.hiltVersion}")
  kapt("com.google.dagger:hilt-compiler:${Constants.hiltVersion}")

  // Hilt testing
  androidTestImplementation("com.google.dagger:hilt-android-testing:${Constants.hiltVersion}")
  kaptAndroidTest("com.google.dagger:hilt-android-compiler:${Constants.hiltVersion}")

  // Room
  implementation("androidx.room:room-runtime:${Constants.roomVersion}")
  kapt("androidx.room:room-compiler:${Constants.roomVersion}")

  // Room testing
  implementation("androidx.room:room-ktx:${Constants.roomVersion}")

  // Detekt
  detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Constants.detektVersion}")

  // Dependencies for local unit tests
  testImplementation("junit:junit:${Constants.junitVersion}")
  testImplementation("androidx.arch.core:core-testing:${Constants.archTestingVersion}")
  testImplementation("androidx.navigation:navigation-testing:${Constants.navigationVersion}")
  testImplementation("androidx.test:core:1.4.0")
  testImplementation("androidx.test.espresso:espresso-core:${Constants.espressoVersion}")
  testImplementation("app.cash.turbine:turbine:${Constants.turbineVersion}")
  testImplementation("com.google.truth:truth:${Constants.truthVersion}")
  testImplementation("io.mockk:mockk:${Constants.mockkVersion}")
  testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Constants.coroutinesVersion}")

  // Dependencies for Android unit tests
  androidTestImplementation("androidx.test.espresso:espresso-core:${Constants.espressoVersion}")
  androidTestImplementation("androidx.navigation:navigation-testing:${Constants.navigationVersion}")
  androidTestImplementation("com.google.truth:truth:${Constants.truthVersion}")
  androidTestImplementation("io.mockk:mockk-android:${Constants.mockkVersion}")

  // AndroidX Test - JVM testing
  debugImplementation("androidx.fragment:fragment-testing:${Constants.fragmentTestingVersion}")

  // AndroidX Test - Instrumented testing
  androidTestImplementation("androidx.test.ext:junit:${Constants.junitExtVersion}")
}

repositories {
  google()
  mavenCentral()
}

detekt {
  buildUponDefaultConfig = true
  parallel = true

  // detekt & formatting plugin not currently reading from .editorconfig correctly, remove when fixed
  config = files("${parent?.rootDir}/.detekt.yml")
}

tasks.withType<Detekt>().configureEach {
  reports {
    html.required.set(false)
    sarif.required.set(false)
  }
}
