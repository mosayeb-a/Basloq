buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BasloqDependencies.kotlinGradlePlugin)
        classpath(BasloqDependencies.androidBuildTools)
        classpath(BasloqDependencies.sqlDelightGradlePlugin)
        classpath(BasloqDependencies.hiltGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
