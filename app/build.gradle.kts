import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.scheduleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.scheduleapp"
        minSdk = 28
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
    val keystoreProperties = Properties().apply {
        load(FileInputStream(rootProject.file("keys.properties")))
    }

    buildTypes.forEach { buildType ->
        buildType.buildConfigField("String", "API_ENDPOINT", keystoreProperties["baseUrl"] as String)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //db lib room
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // di lib dagger2
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    // viewModel lib
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // remote libs
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // navigation lib
    implementation(libs.cicerone)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation(project(":common"))
    implementation(project(":schedule"))

}