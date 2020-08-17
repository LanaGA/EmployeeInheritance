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

    compileOnly ("org.projectlombok", "lombok", "1.18.12")
    annotationProcessor ("org.projectlombok", "lombok", "1.18.12")
    testCompileOnly ("org.projectlombok", "lombok", "1.18.12")
    testAnnotationProcessor ("org.projectlombok","lombok","1.18.12")
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.0.1")
    implementation("com.squareup.okhttp3:okhttp:4.8.1")
    testCompile("junit", "junit", "4.12")
    implementation(kotlin("script-runtime", "1.3.70"))
}
