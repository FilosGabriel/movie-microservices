plugins {
    java
    id("io.freefair.lombok") version "6.0.0-m2"

}

group = "com.filos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine");
    compileOnly("com.univocity:univocity-parsers:2.9.1");
    compileOnly("com.google.code.gson:gson:2.8.6");

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}