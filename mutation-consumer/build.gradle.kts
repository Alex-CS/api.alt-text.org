import dev.hbeck.alt.text.shared.Versions

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.0"
}

//val pbandkVersion by extra("0.8.1")

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
    maven("https://maven.pkg.github.com/alt-text-org/alt-text-protos") {
        credentials(HttpHeaderCredentials::class) {
            name = "Authorization"
            value = "Bearer ${project.findProperty("gpr.token") as String}"
        }
        authentication {
            create<HttpHeaderAuthentication>("header")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":common"))
    implementation(project(":storage"))
    implementation(project(":heuristics"))
    implementation(project(":twitter"))
    implementation(project(":safety"))

    implementation("io.github.microutils:kotlin-logging:${Versions.kotlinLogging}")
    implementation("javax.validation:validation-api:${Versions.javaxValidation}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jacksonModule}")

    implementation("com.google.inject:guice:${Versions.guice}")
    implementation("com.google.firebase:firebase-admin:${Versions.firebaseAdmin}")

    implementation("org.alt-text:alt-text-protos:${Versions.altTextProtos}")
    implementation("com.github.streem.pbandk:pbandk-runtime-jvm:${Versions.pbandk}")
}