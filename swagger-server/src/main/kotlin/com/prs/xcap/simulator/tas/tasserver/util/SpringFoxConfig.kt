package com.prs.xcap.simulator.tas.tasserver.util

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SpringFoxConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prs.xcap.simulator.tas.tasserver.rest"))
//                .paths(regex("/services.*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
    }



    private fun metaData(): ApiInfo {
        return ApiInfoBuilder()
                .title("TAS REST API")
                .description("\"TAS REST API for m1.com\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(Contact("Sampath Nawglala", "https://springframework.guru/about/", "john@springfrmework.guru"))
                .build()
    }
}
