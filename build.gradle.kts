plugins {
	java
	id("io.spring.dependency-management") version "1.0.6.RELEASE"
	id("org.springframework.boot") version "2.1.2.RELEASE"
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	mavenCentral()
}

val developmentOnly: Configuration by configurations.creating

configurations {
	runtimeClasspath {
		extendsFrom(configurations["developmentOnly"])
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("com.hazelcast:hazelcast")
	implementation("org.hibernate:hibernate-jcache")
	implementation("org.springframework.session:spring-session-hazelcast")

	runtimeOnly("com.h2database:h2")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
