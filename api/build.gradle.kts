plugins {
    id("build.library")
    id("build.publish")
}

dependencies {

    api("dev.jwall64:midnightcfg-api:3.0.1")
    compileOnly(libs.jetbrains.annotations)
}