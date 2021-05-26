plugins {
    java
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.filos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
ext.set("springCloudVersion", "2020.0.2")

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2020.0.2"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
