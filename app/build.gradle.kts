plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.eugenics.barrier"
    compileSdk = Main.sdkVersion

    defaultConfig {
        applicationId = Main.applicationId
        minSdk = Main.minSdkVersion
        targetSdk = Main.sdkVersion
        versionCode = Main.versionCode
        versionName = Main.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = Main.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Main.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleRuntimeKtx)
    implementation(Compose.activityCompose)
    implementation(Compose.composeUi)
    implementation(Compose.composeUiToolingPreview)
    implementation(Compose.composeMaterial3)
    testImplementation(Test.junitVersion)
    androidTestImplementation(Test.junitExtVersion)
    androidTestImplementation(Test.espressoCore)
    androidTestImplementation(Compose.composeUiTestJunit)
    debugImplementation(Compose.composeUiTooling)
    debugImplementation(Compose.composeUiTestManifest)
}