/**
 * @author muaz
 * Created on 6/14/2022.
 */
object Libs {

    const val material = "com.google.android.material:material:${Versions.material}"

    object AndroidX {
        const val core_ktx: String = "androidx.core:core-ktx:" + Versions.coreKtx
        const val androidx_appcompat: String = "androidx.appcompat:appcompat:" + Versions.appCompat
        const val constraint_layout: String =
            "androidx.constraintlayout:constraintlayout:" + Versions.constraint
        const val legacy_support: String =
            "androidx.legacy:legacy-support-v4:" + Versions.legacy_support
    }

    object Navigation {
        const val navigation_fragment_ktx: String =
            "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation
        const val navigation_ui_ktx: String =
            "androidx.navigation:navigation-ui-ktx:" + Versions.navigation
        const val safe_args_plugin: String =
            "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.navigation
    }

    object DaggerHilt {
        const val daggerHilt = "com.google.dagger:hilt-android:" + Versions.hilt
        const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:" + Versions.hilt
        const val daggerHiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:" + Versions.hilt
    }

    object Debug {
        const val timber: String = "com.jakewharton.timber:timber:" + Versions.timber
    }

    object UnitTest {
        const val junit = "junit:junit:${Versions.junit}"
        const val junit_test: String = "androidx.test.ext:junit:" + Versions.junit_test
        const val espresso: String = "androidx.test.espresso:espresso-core:" + Versions.espresso
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:" + Versions.glide
        const val compiler = "com.github.bumptech.glide:compiler:" + Versions.glide
    }

    object Coroutines {
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
        const val converter = "com.squareup.retrofit2:converter-gson:" + Versions.retrofit
        const val okhttp = "com.squareup.okhttp3:okhttp:" + Versions.ok_http
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.ok_http
    }

    object LifeCycle{
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.lifecycle
        const val common = "androidx.lifecycle:lifecycle-common-java8:" + Versions.lifecycle
    }

}