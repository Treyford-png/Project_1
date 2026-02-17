
plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("org.json:json:20240303")
    implementation("org.slf4j:slf4j-simple:2.0.12")
    implementation("net.minidev:json-smart:2.5.0")
}

tasks.test {
    useJUnitPlatform()
}

javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
}
application {
    mainClass.set("edu.bsu.cs222.GUI_Main")
}
