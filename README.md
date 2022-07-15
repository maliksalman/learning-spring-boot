# learning-spring-boot

A repository for learning spring-boot. Each commit introduces a different feature.

## Pre-requisites

- Java 17 or higher
- Gradle
- A nice IDE (Intellij Idea, VS Code, Eclipse, etc)

## Installing Java 17  

### Installing with `brew`

```bash
brew install openjdk
```

Check java version after successful installation

```bash
java -version
```

If you don't see the required version, try either of the following options.

### Installing with `sdkman`

```bash
curl -s "https://get.sdkman.io" | bash
```

Use below command to see what you could install

```bash
sdk list java
```

Install the desired version

```bash
sdk install java 17.0.3-oracle
```

### Installing from `jdk archive downloads`

Download Java 17 from [jdk17-archive-downloads](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) and install it.

Check java version after successful installation

```bash
java -version
```

## Build

```
./gradlew clean build
```

## Run

```
java -jar build/libs/learning-spring-boot-1.0.jar
```

> If you want to build and run the application with just one command, use `./gradlew clean bootrun`

Check your endpoints

```bash
curl localhost:8080/greeting/10
```

## References

* [start.spring.io](https://start.spring.io/)
* [sdkman.io](https://sdkman.io/)
* [How to create initial application with spring initializer](create-application-wth-spring-initializer.md)