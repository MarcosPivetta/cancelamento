@ECHO OFF
set BASE_DIR=%~dp0
set MVNW_JAR=%BASE_DIR%\.mvn\wrapper\maven-wrapper.jar
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
java -Dmaven.multiModuleProjectDirectory=%BASE_DIR% -cp %MVNW_JAR% %WRAPPER_LAUNCHER% %*
