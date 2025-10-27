/**
 *
 * Projeto: santander-api
 * Autor: Sheyla Vaz
 * Data de criação: 23/10/2025
 *
 */


package dio.santander.api.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API RESTful - Santander/DIO")
                        .version("1.0.0")
                        .description("Descrição detalhada da sua API REST com Spring Boot 3.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Sheyla")
                                .url("http://seuwebsite.com")
                                .email("seuemail@dominio.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}