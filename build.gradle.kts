import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
}

group = "cloud.csonic"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	{
		exclude(module = "junit")
		exclude(module = "mockito-core")
		//exclude(module = "org.junit.vintage")
	}



	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
	//testImplementation("org.junit.jupiter:junit-jupiter-params")
	//testImplementation("org.junit.vintage:junit-vintage-engine")
	//testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")



	testImplementation("com.ninja-squad:springmockk:3.0.1")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {

	// Enable JUnit 5 (Gradle 4.6+).
	useJUnitPlatform(){
		includeEngines("junit-jupiter")
		excludeEngines("junit-vintage")
	}
	reports{
		junitXml.required.set(true)

	}


	testLogging{
		exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
		events( "started", "passed", "skipped", "failed", "standardOut", "standardError")


	}
}


