plugins {
    java

}
allprojects {
    version = "0.1";
    group = "com.filos";
    repositories {
        mavenCentral()
    }
    extra.set("vMapper", "1.4.2.Final")
    extra.set("vCommonsLang", "3.12.0")
    extra.set("vJupiterEngine", "5.6.0")
    extra.set("vDSLMongo", "4.2.2")
    extra.set("vQueryDsl", "4.2.2")
    extra.set("vJavax", "1.3.2")
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

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") {
            doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }
}

apply<GreetingPlugin>()
apply(from = "dependency.gradle")