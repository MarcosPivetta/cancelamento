#!/bin/sh
BASE_DIR="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
MVNW_JAR="$BASE_DIR/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
exec java -Dmaven.multiModuleProjectDirectory="$BASE_DIR" -cp "$MVNW_JAR" $WRAPPER_LAUNCHER "$@"
