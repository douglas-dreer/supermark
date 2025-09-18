plugins {
	kotlin("jvm") version "2.2.0"
	kotlin("plugin.spring") version "2.2.0"
	kotlin("plugin.jpa") version "2.2.0"
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "br.com.supermark"
version = "0.0.1-SNAPSHOT"
description = "supermark"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Kotlin essentials (deve vir primeiro) - VERSÕES EXPLÍCITAS
	implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.0") {
		because("Obrigatório para Spring Data JPA com Kotlin")
	}
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.2.0")

	// Spring Boot starters
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.kafka:spring-kafka")

	// QR Code e Código de Barras
	implementation("com.google.zxing:core:3.5.2")
	implementation("com.google.zxing:javase:3.5.2")

	// Database
	runtimeOnly("com.h2database:h2")

	// Test dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Configurações do Kotlin
kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

// Configuração dos testes
tasks.withType<Test> {
	useJUnitPlatform()
	// Opcional: pular testes condicionalmente
	enabled = !project.hasProperty("skipTests")
}

// Configuração da JVM para o bootRun
tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun> {
	jvmArgs = listOf("-Dspring.profiles.active=dev")
}