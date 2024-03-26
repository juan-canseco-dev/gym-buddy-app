plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "jcanseco.dev.gymbuddy"
    compileSdk = 34

    defaultConfig {
        applicationId = "jcanseco.dev.gymbuddy"
        minSdk = 24
        targetSdk = 33
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

    dataBinding {
        enable = true
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    val arch_version = "2.1.0"

    val core_version = "1.9.0"
    val app_compat_version = "1.6.1"
    val material_version = "1.10.0"
    val constraint_version = "2.1.4"
    val splash_version = "1.0.1"



    val lifecycle_version = "2.6.2"
    val fragment_version = "1.6.2"
    val nav_version = "2.7.5"
    val hilt_version = "2.44"

    implementation("androidx.core:core-ktx:$core_version")
    implementation("androidx.appcompat:appcompat:$app_compat_version")
    implementation("com.google.android.material:material:$material_version")
    implementation("androidx.constraintlayout:constraintlayout:$constraint_version")
    implementation("androidx.core:core-splashscreen:$splash_version")

    // Life cycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    // Fragments
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Nav
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")


    // DI
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt {
    correctErrorTypes = true
}