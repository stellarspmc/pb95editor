import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}

group = "fun.spmc"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    //macosArm64()
    //linuxArm64()
    linuxX64()
    mingwX64()

    targets.withType<KotlinNativeTarget>().configureEach {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        nativeMain.dependencies {
            implementation(libs.kotlinxSerializationJson)
	        implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.9.2")
        }
    }
}
