/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.utils;

import com.google.common.base.Predicate;
import static com.google.common.base.Predicates.or;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 *
 * @author Desarrollo3
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    /**
     * Publish a bean to generate swagger2 endpoints
     *
     * @return a swagger configuration bean
     */
    @Bean
    public Docket demosApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(demosApiInfo())
                .select()
                .paths(paths())
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo demosApiInfo() {
        return new ApiInfoBuilder()
//                .title("Service Demo")
//                .version("1.0")
//                .license("Apache License Version 2.0")
//                .build();
                .title("Demo Services")
                .description("Spring Boot Documantation  with Swagger")
//                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Jhon Mario Murillo Cordoba")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

//    private Predicate userPaths() {
//        return regex("/Barrio.*");
//    }
    private Predicate<String> paths() {
        return or(
                regex("/Barrio.*"),
                regex("/Ciudad.*"),
                regex("/Departamento.*"),
                regex("/Pais.*"));
    }
}
