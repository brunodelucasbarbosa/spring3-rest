plugins {
	java
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "br.com.course"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.github.dozermapper:dozer-core:6.4.0")
	implementation("org.flywaydb:flyway-core")
	// https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.1")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.1")
	// https://mvnrepository.com/artifact/org.springframework.hateoas/spring-hateoas
	implementation("org.springframework.hateoas:spring-hateoas:2.0.1")
	implementation("org.mockito:mockito-core:5.1.1")
	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui
	implementation("org.springdoc:springdoc-openapi-ui:1.6.14")
	implementation("io.rest-assured:rest-assured:5.3.0")
	implementation("org.testcontainers:testcontainers-bom:1.17.6") //import bom
	testImplementation("org.testcontainers:postgresql:1.17.6") //no version specified



	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
