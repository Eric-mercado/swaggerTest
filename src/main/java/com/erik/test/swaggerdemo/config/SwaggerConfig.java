package com.erik.test.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket producApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.erik.test.swaggerdemo"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaIndfo());
    }

    private ApiInfo metaIndfo() {
        return new ApiInfo(
                "Spring Boot Swagger Example API",
                "Spring Boot Swager Example Api for youtbe",
                "1.0",
                "Terms of Service",
                new Contact("ErickongoBbongo", "www.google.com", "eric.m.mercado@gmail.com"),
                "Apache Licence 2.0",
                "www.google.com"
        );
    }
}
