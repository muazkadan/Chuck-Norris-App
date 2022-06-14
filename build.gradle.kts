// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

buildscript {
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}")
        classpath(Libs.Navigation.safe_args_plugin)
        classpath(Libs.DaggerHilt.daggerHiltGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
