package com.sdmobile.sdmobileback.doc;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "SD-Mobile",
        version = "1.0",
        description = "API do Grupo 2 para o projeto de Sistemas Distribuidos"
    )
)
public class SwaggerConfig {
	
}

