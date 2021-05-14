plugins {
    idea
    java
    `java-library`
    id("io.freefair.lombok") version "6.0.0-m2"
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

}

group = "com.filos"
version = "1.0-SNAPSHOT"

idea{
    module {
        sourceDirs.add(file("generated/"))
        generatedSourceDirs.add(file("generated/"))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":utils:data-loader"))
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

    implementation("com.querydsl:querydsl-mongodb:4.2.2")
    implementation("com.querydsl:querydsl-core:4.2.2")
    annotationProcessor("com.querydsl:querydsl-apt:4.2.2:general")
    annotationProcessor("javax.annotation:javax.annotation-api:1.3.2")

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