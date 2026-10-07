underwriting-service: Risk assessment and underwriting rules.

Part of the demo platform: Java 8, Spring Boot 2.7.0, Spring Cloud 2021.0.3.
Registers itself with eureka-server on startup, so the gateway can route to it
by name (lb://underwriting-service). On Cloud Foundry it gets an internal-only route
(underwriting-service.apps.internal); only the gateway is exposed publicly.

## Endpoints (static demo responses)

See the controller in src/main/java/com/dashaun/demo/*/web. All responses are
static values; there is no database and no real inter-service calls.

## /actuator/info

Reports what the platform is running, which is the point of the demo:

- spring.boot.version - the Spring Boot version (via SpringBootVersion)
- java.version / vendor / vm - the JRE the service is running on
- startup.startedAt - wall-clock time this instance was started, e.g.
  '4:34pm on October 6, 2026' (formatted in America/Chicago, configurable via
  demo.timezone)
- startup.uptimeSeconds - seconds since this instance started

Redeploy the service and the gateway landing page (http://api-gateway.dashaun.group)
shows the new version and a fresh startup time within 10 seconds.

## Run

    ./mvnw spring-boot:run

Listens on port 8080, or the PORT environment variable when deployed to Cloud
Foundry. Point it at a local registry for development:

    EUREKA_URL=http://localhost:8090/eureka EUREKA_INSTANCE_HOSTNAME=localhost ./mvnw spring-boot:run

