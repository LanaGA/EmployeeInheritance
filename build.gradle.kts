plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "Main"
}

repositories {
    mavenCentral()
}

dependencies {

    implementation ("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:okhttp:4.8.1")
    testCompile("junit", "junit", "4.12")
    implementation(kotlin("script-runtime", "1.3.70"))
}
