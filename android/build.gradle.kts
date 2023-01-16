plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    kotlin("android")

}

android {
    namespace = "com.almalk.footballmatches.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.almalk.footballmatches.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    hilt {
        enableAggregatingTask = true
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.3")
    implementation("androidx.compose.ui:ui-tooling:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")


    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-compiler:2.44")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    //systemuicontroller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")
    implementation("com.google.accompanist:accompanist-insets:0.23.1")

    //circular image
    implementation ("io.coil-kt:coil-compose:2.0.0-rc03")

}