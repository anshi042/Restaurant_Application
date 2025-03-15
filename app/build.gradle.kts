plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.restaurantapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.restaurantapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    // **Retrofit for API calls**
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // **OkHttp for API Logging**
    implementation(libs.logging.interceptor.v493)

    // **Coroutine support for Networking**
    implementation(libs.kotlinx.coroutines.android)

    // **Gson for JSON Parsing**
    implementation(libs.gson)

    // **Coil for Image Loading in Jetpack Compose**
    implementation(libs.coil.compose)

    implementation (libs.androidx.room.runtime)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.cardview)
    annotationProcessor(libs.androidx.room.compiler)

    // For Kotlin Coroutines
    implementation (libs.androidx.room.ktx)

    implementation(libs.github.glide)
    annotationProcessor(libs.compiler)

    implementation(libs.androidx.recyclerview.v132)



    implementation(libs.material)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation (libs.androidx.recyclerview.v132)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


}