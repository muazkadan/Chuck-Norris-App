plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Libs.AndroidX.core_ktx)
    implementation(Libs.AndroidX.androidx_appcompat)
    implementation(Libs.material)
    implementation(Libs.AndroidX.constraint_layout)
    testImplementation(Libs.UnitTest.junit)
    androidTestImplementation(Libs.UnitTest.junit_test)
    androidTestImplementation(Libs.UnitTest.espresso)

    // navigation
    implementation(Libs.Navigation.navigation_fragment_ktx)
    implementation(Libs.Navigation.navigation_ui_ktx)

    // hilt
    implementation(Libs.DaggerHilt.daggerHilt)
    kapt(Libs.DaggerHilt.daggerHiltCompiler)

    // timber
    implementation(Libs.Debug.timber)
}
