
package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/4/19.
 * <p>
 * <p>
 * Describe: swagger 配置类
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //http://localhost:8080/swagger-ui.html
    /**
     * 全局参数
     * @return
     */
    private List<Parameter> parameter() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("Authorization")
                .description("Authorization Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build());
        return params;

    }


    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameter());


    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" activiti ")
                .description(" boot 脚手架")
                .termsOfServiceUrl("")
                .contact(" chenye ")
                .version("1.0")
                .build();
    }

}

