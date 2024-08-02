plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.jetbrainsSerialization)
    application
}

group = "br.com.lobolabs.ebalance"
version = "1.0.0"
application {
    mainClass.set("br.com.lobolabs.ebalance.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.serialization.json)
    implementation(libs.ktor.server.netty)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)

    implementation(libs.ktor.koin)

    implementation("org.ktorm:ktorm-core:3.5.0")
    implementation("org.ktorm:ktorm-support-postgresql:3.5.0")
    implementation("org.postgresql:postgresql:42.5.1")

    implementation("commons-codec:commons-codec:1.15")

    implementation("io.ktor:ktor-server-auth:2.3.12")
    implementation("io.ktor:ktor-server-auth-jwt:2.3.12")

    implementation("com.twilio.sdk:twilio:9.1.4")
    implementation("com.sendgrid:sendgrid-java:4.9.3")

}