# Copilot instructions

## Build, test, and run

- Use the Maven wrapper from the repository root so Maven 3.10.0 is used consistently:
  `.\mvnw.cmd clean package`
- Run the complete test suite with:
  `.\mvnw.cmd test`
- Run one test class with:
  `.\mvnw.cmd -Dtest=DemoApplicationTests test`
- Run one test method with:
  `.\mvnw.cmd -Dtest=DemoApplicationTests#contextLoads test`
- Start the application locally with:
  `.\mvnw.cmd spring-boot:run`
- The project targets Java 21. No dedicated lint or formatter plugin is configured in `pom.xml`; do not invent a lint command.

## Architecture

This is a small Spring Boot MVC application. `DemoApplication` is the `@SpringBootApplication` entry point in the `DistributedApplications2026.com.example.demo` package; keep new Spring components below that package (or explicitly configure component scanning) so Boot discovers them.

The Maven configuration combines Spring Web MVC, Thymeleaf server-side rendering, Spring Data JDBC, H2 at runtime, and the Spring Boot H2 console. Application configuration currently lives in `src/main/resources/application.properties` and only sets the application name. Tests are under the same package hierarchy and use `@SpringBootTest`, so they validate application-context startup rather than a sliced web or persistence layer.

## Repository-specific conventions

- Preserve the existing Java package prefix and directory layout: `src/main/java/DistributedApplications2026/com/example/demo` and the matching test package.
- Use Spring Boot dependency management from the `spring-boot-starter-parent`; dependency versions are intentionally omitted from individual dependencies in `pom.xml`.
- Keep runtime-only dependencies, such as H2, scoped as `runtime`; test-only Spring Boot test starters remain scoped as `test`.
- Put environment-independent defaults in `application.properties`; keep environment-specific values out of source-controlled configuration.
- The generated `HELP.md` documents the current Spring Web, Thymeleaf, and Spring Data JDBC stack; update it only if the project structure or supported capabilities change.
