plugins {
    id("build.library")
    id("build.publish")
}

dependencies {

    api("dev.jwall64:midnightcfg-api:3.1.0")
    api("dev.jwall64:midnightcfg-codec-nbt:3.1.0")
    api(project(":api"))

    compileOnly(libs.jetbrains.annotations)
}