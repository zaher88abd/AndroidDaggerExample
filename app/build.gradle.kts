plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-android")
    id("kotlin-kapt")

}

android {
    namespace = "dev.zaherabd.daggerexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.zaherabd.daggerexample"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    val okhttpVersion = "4.9.3"
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:${retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-gson:${retrofitVersion}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${retrofitVersion}")
    implementation("com.squareup.okhttp3:okhttp:${okhttpVersion}")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:${okhttpVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${okhttpVersion}")
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // RxJava
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")

    // Dagger
    val daggerVersion = "2.46.1"
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}