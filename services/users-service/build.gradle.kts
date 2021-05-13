plugins {
    java
    `java-library`
    id("io.freefair.lombok") version "6.0.0-m2"
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.filos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    other projects
//    fi
    implementation(project(":core:domain"))
    implementation(project(":utils:communication"))

//    spring framework
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2020.0.2"))
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.cloud:spring-cloud-starter-config")

//    qr image code
    implementation("com.google.zxing:javase:3.3.0")
    implementation("com.google.zxing:core:3.3.0")

//    password and tokens
    implementation("me.gosimple:nbvcxz:1.5.0")
    implementation("com.auth0:java-jwt:3.4.0")

//    utility
    implementation("commons-codec:commons-codec:1.11")
    implementation("org.apache.commons:commons-lang3:3.5")
    implementation("com.google.guava:guava:30.1-jre")

//    beans
    implementation("org.modelmapper:modelmapper:2.3.0")
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

//    testing
    testImplementation("org.spockframework:spock-core:2.0-M4-groovy-3.0")
    testImplementation("org.spockframework:spock-junit4:2.0-M4-groovy-3.0")
    testImplementation("org.codehaus.groovy:groovy:2.5.14")
    testImplementation("net.bytebuddy:byte-buddy:1.10.10")
    testImplementation("org.assertj:assertj-core:3.19.0")
    testImplementation("org.objenesis:objenesis:3.1")
    testImplementation("org.hamcrest:hamcrest-core:2.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.9.0")
    testImplementation("org.mockito:mockito-junit-jupiter:3.9.0")
    testImplementation("org.junit.platform:junit-platform-runner:1.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
