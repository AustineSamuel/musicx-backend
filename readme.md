# MusicX

## Run the application

Requirements: Java 17.

From the project directory, start the Spring Boot application with the Maven
wrapper:

```bash
./mvnw spring-boot:run
```

On Windows, use:

```bat
mvnw.cmd spring-boot:run
```

When the application has started, visit [http://localhost:8080/](http://localhost:8080/).
The application logs the port it is listening on at startup. Press `Ctrl+C` in
the terminal to stop it.

## Development refresh mode

Spring Boot DevTools is included for development. Start the app with
`./mvnw spring-boot:run` as above. When you change Java code, recompile it so
DevTools can detect the updated class files and restart the application:

```bash
./mvnw compile
```

Run that command after saving changes, or configure your IDE to build
automatically. DevTools restarts the application; it does not automatically
refresh the browser page, so reload it at [http://localhost:8080/](http://localhost:8080/).

Alternatively, run the packaged JAR (build it first with `./mvnw package`):

```bash
java -jar target/musicx-0.0.1-SNAPSHOT.jar
```

## Maven dependencies

Maven downloads project dependencies automatically when you build or test the
project. For example:

```bash
./mvnw compile
```

To explicitly resolve and download declared dependencies without compiling:

```bash
./mvnw dependency:resolve
```

To add a dependency, declare it in `pom.xml` under `<dependencies>`. Maven will
resolve it the next time you build. `./mvnw install` is not the equivalent of
`npm install`: it builds the project and installs its artifact in your local
Maven repository.

## Read runtime setting

The app exposes a read-only endpoint for one allowlisted, non-secret setting.
Get its effective value (from `application.properties` or the environment)
with:

```bash
curl http://localhost:8080/settings/app.display-name
```

The environment variable `APP_DISPLAY_NAME` overrides the property. For
example, set it when starting the app:

```bash
APP_DISPLAY_NAME="My Music App" ./mvnw spring-boot:run
```

The endpoint only returns `app.display-name`; it does not expose arbitrary
environment variables, read or write `.env` files, or return secrets.# musicx-backend
