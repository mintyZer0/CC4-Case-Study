# CC4-Case-Study

This repository contains a small Java example application.

## Java runtime requirement

This project should be run with the latest LTS Java: **Java 21**.

### Quick check

You can quickly verify your Java runtime with the provided script:

```sh
./tools/check-java-version.sh
```

If your system Java is not Java 21, the script will print guidance to install Java 21.

### Installing Java 21 (Linux)

Recommended options:

- SDKMAN (works on many Linux distros):

	```sh
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk install java 21.0.0-tem
	sdk use java 21.0.0-tem
	```

- Debian/Ubuntu (using packages from vendors or apt when available):

	```sh
	sudo apt update
	sudo apt install -y openjdk-21-jdk
	```

Adjust installation steps for your distribution or use a vendor binary (Adoptium, Azul, Oracle).

### Compile & run

For this simple project (no build system), use:

```sh
javac Main.java
java Main
```

### Notes

- If you have a build system (Maven/Gradle), add a toolchain or set the Java version to 21 in the corresponding config (pom.xml / build.gradle).
- If you want, I can detect and update build files (pom.xml or build.gradle) to target Java 21 — tell me and I'll proceed.
