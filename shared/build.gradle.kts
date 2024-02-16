plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version BasloqDependencies.kotlinVersion
    id("com.squareup.sqldelight")
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

//    cocoapods {
//        summary = "Some description for the Shared Module"
//        homepage = "Link to the Shared Module homepage"
//        version = "1.0"
//        ios.deploymentTarget = "14.1"
//        podfile = project.file("../iosApp/Podfile")
//        framework {
//            isStatic = false
//            baseName = "shared"
//        }
//    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }

    sourceSets {
        val desktopMain by getting {
            dependencies {
                implementation(BasloqDependencies.ktorCIO)
                implementation(BasloqDependencies.ktorLogging)

            }
        }

        val commonMain by getting {
            dependencies {
                implementation(BasloqDependencies.ktorCore)
                implementation(BasloqDependencies.ktorSerialization)
                implementation(BasloqDependencies.ktorSerializationJson)
                implementation(BasloqDependencies.sqlDelightRuntime)
                implementation(BasloqDependencies.sqlDelightCoroutinesExtensions)
                implementation(BasloqDependencies.kotlinDateTime)
                implementation(BasloqDependencies.ktorLogging)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(BasloqDependencies.assertK)
                implementation(BasloqDependencies.turbine)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(BasloqDependencies.ktorAndroid)
                implementation(BasloqDependencies.sqlDelightAndroidDriver)
                implementation(BasloqDependencies.ktorLogging)

            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(BasloqDependencies.ktorIOS)
                implementation(BasloqDependencies.sqlDelightNativeDriver)
                implementation(BasloqDependencies.ktorLogging)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.ma.basloq"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    database("BasloqDatabase") {
        packageName = "com.ma.basloq.database"
        sourceFolders = listOf("sqldelight")
    }
}