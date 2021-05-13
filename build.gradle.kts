plugins {
    java
}
allprojects {
    version = "0.1";
    group = "com.filos";
    repositories {
        mavenCentral()
    }
    apply(plugin = "java")
}
group = "com.filos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}