
package vn.fpt.edu.aqualife.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "AquaLife", email = "contact@AquaLife.com", url = "https://AquaLife.com"),
                description = "OpenApi documentation for AquaLife application",
                title = "OpenApi specification - AquaLife GitHub",
                version = "1.0",
                license = @License(name = "License name", url = "https://some-url.com"),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(description = "Local ENV", url = "http://localhost:8080"), @Server(description = "Production ENV", url = "http://103.245.236.207:8080")
        },
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenAPIConfig {
}
