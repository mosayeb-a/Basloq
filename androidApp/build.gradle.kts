plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization") version BasloqDependencies.kotlinVersion
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.ma.basloq.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.ma.basloq.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.ma.basloq.TestHiltRunner"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BasloqDependencies.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(BasloqDependencies.composeUi)
    implementation(BasloqDependencies.composeUiTooling)
    implementation(BasloqDependencies.composeUiToolingPreview)
    implementation(BasloqDependencies.composeFoundation)
    implementation(BasloqDependencies.composeMaterial)
    implementation(BasloqDependencies.activityCompose)
    implementation(BasloqDependencies.composeNavigation)
    implementation(BasloqDependencies.coilCompose)

    implementation(BasloqDependencies.hiltAndroid)
    kapt(BasloqDependencies.hiltAndroidCompiler)
    kapt(BasloqDependencies.hiltCompiler)
    implementation(BasloqDependencies.hiltNavigationCompose)

    implementation(BasloqDependencies.ktorAndroid)

    androidTestImplementation(BasloqDependencies.testRunner)
    androidTestImplementation(BasloqDependencies.jUnit)
    androidTestImplementation(BasloqDependencies.composeTesting)
    androidTestImplementation(BasloqDependencies.rules)
    debugImplementation(BasloqDependencies.composeTestManifest)

    kaptAndroidTest(BasloqDependencies.hiltAndroidCompiler)
    androidTestImplementation(BasloqDependencies.hiltTesting)
}