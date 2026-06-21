plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.artetris.mobile"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.artetris.mobile"
        minSdk = 26
        targetSdk = 36
        versionCode = providers.gradleProperty("ARTETRIS_VERSION_CODE").map(String::toInt).getOrElse(1)
        versionName = providers.gradleProperty("ARTETRIS_VERSION_NAME").getOrElse("1.0.0")
    }

    signingConfigs {
        create("release") {
            val storeFilePath = providers.gradleProperty("ARTETRIS_RELEASE_STORE_FILE").orNull
            if (!storeFilePath.isNullOrBlank()) {
                storeFile = file(storeFilePath)
                storePassword = providers.gradleProperty("ARTETRIS_RELEASE_STORE_PASSWORD").orNull
                keyAlias = providers.gradleProperty("ARTETRIS_RELEASE_KEY_ALIAS").orNull
                keyPassword = providers.gradleProperty("ARTETRIS_RELEASE_KEY_PASSWORD").orNull
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            if (!providers.gradleProperty("ARTETRIS_RELEASE_STORE_FILE").orNull.isNullOrBlank()) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2025.05.01"))
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.datastore:datastore-preferences:1.1.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.1")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
