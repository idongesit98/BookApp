plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
    id ("org.jetbrains.kotlin.plugin.serialization")
    kotlin("kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.zseni.librebook"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zseni.librebook"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val retrofitVersion = "2.9.0"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // compose-navigation dependencies
    implementation ("androidx.navigation:navigation-compose:2.7.5")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    //DataSource Implementation
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // database - Room
    implementation("androidx.room:room-ktx:2.6.0")
    ksp("androidx.room:room-compiler:2.6.0")

    // retrofit and gson,okhttp dependencies
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    // hilt dependencies
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // viewModel-compose dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    kapt("androidx.lifecycle:lifecycle-compiler:2.6.2")

    //Lottie
    implementation("com.airbnb.android:lottie-compose:6.0.1")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Kotlinx Serialiazble
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    //Animated Navigation Bar
    implementation("com.exyte:animated-navigation-bar:1.0.0")

}