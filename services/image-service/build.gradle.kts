plugins {
    java
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("io.freefair.lombok") version "6.0.0-m2"
}

group = "com.filos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2020.0.2"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("net.coobird:thumbnailator:0.4.14")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.mockito:mockito-core:3.6.28")
    testRuntimeOnly("org.mockito:mockito-junit-jupiter:3.9.0")
    testRuntimeOnly("com.google.guava:guava:30.1-jre")
    implementation("org.apache.commons:commons-imaging:1.0-alpha2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
}
tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}