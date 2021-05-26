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
val vMapper: String by project.extra
val vCommonsLang: String by project.extra
val vJupiterEngine: String by project.extra
val vDSLMongo: String by project.extra
val vQueryDsl: String by project.extra
val vJavax: String by project.extra

repositories {
    mavenCentral()
}

dependencies {
//  other projects
    implementation(project(":utils:data-loader"))

//  Media
    implementation("black.door:hate:v1r4t5")

//  Utils
    implementation("org.mapstruct:mapstruct:${vMapper}")
    implementation("org.apache.commons:commons-lang3:${vCommonsLang}")

//  Spring boot
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2020.0.0"))
    implementation(	"org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

//    TESTING junit
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${vJupiterEngine}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${vMapper}")

//    queryDSL
    implementation("com.querydsl:querydsl-mongodb:${vDSLMongo}")
    implementation("com.querydsl:querydsl-core:${vQueryDsl}")
    annotationProcessor("com.querydsl:querydsl-apt:${vQueryDsl}:general")
    annotationProcessor("javax.annotation:javax.annotation-api:${vJavax}")

//    Documentation
    implementation("org.springdoc:springdoc-openapi-ui:1.5.9")
}
idea {
    module {
        sourceDirs.add(file("generated/"))
        generatedSourceDirs.add(file("generated/"))
    }
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
