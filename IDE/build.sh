#!/bin/bash

# First, ensure we have required tools
echo "Checking and installing required tools..."
sudo apt-get update
sudo apt-get install -y openjdk-17-jdk wixl fakeroot rpm

# Clean previous builds
echo "Cleaning previous builds..."
mvn clean

# Create the basic jar with dependencies
echo "Creating fat JAR..."
mvn package

# Create the runtime image
echo "Creating runtime image..."
mvn javafx:jlink

# Windows Build
echo "Creating Windows executable..."
jpackage \
  --input target \
  --name YourAppName \
  --main-jar your-app-name-1.0-SNAPSHOT.jar \
  --main-class com.example.ide.ide.HelloApplication \
  --type exe \
  --dest target/windows \
  --win-console \
  --win-shortcut \
  --win-menu

# Linux Build
echo "Creating Linux package..."
jpackage \
  --input target \
  --name YourAppName \
  --main-jar your-app-name-1.0-SNAPSHOT.jar \
  --main-class com.example.ide.ide.HelloApplication \
  --type deb \
  --dest target/linux \
  --linux-shortcut \
  --linux-menu-group "Development"

echo "Build process completed!"