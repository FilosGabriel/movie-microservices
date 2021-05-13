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
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.0")
    implementation("me.gosimple:nbvcxz:1.5.0")
    implementation("org.modelmapper:modelmapper:2.3.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.4.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}