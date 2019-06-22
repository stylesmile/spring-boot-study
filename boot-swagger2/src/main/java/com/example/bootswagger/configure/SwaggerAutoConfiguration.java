package com.example.bootswagger.configure;//package com.stylesmile.console.configure;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.ResponseEntity;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.SecurityConfiguration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.time.LocalDate;
//
///**
// * @author carfield
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerAutoConfiguration {
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("标题")
//                .description("陈烨的描述")
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .termsOfServiceUrl("http://swagger.io/terms/")
//                .version("0.0.1").contact(new Contact("chenye.vip", "http://chenye.vip", "chenye.vip@163.com"))
//                .build();
//    }
//
//    @Bean
//    public Docket customImplementation() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                //.securitySchemes(newArrayList(apiKey()))
//                .select().paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.qmcloud.ucenter"))
//                .build()
//                .pathMapping("/")
//                .useDefaultResponseMessages(false)
//                .directModelSubstitute(LocalDate.class, String.class)
//                .genericModelSubstitutes(ResponseEntity.class)
//                ;
//    }
//
////    private ApiKey apiKey() {
////        return new ApiKey("JWT auth", "Authorization", "header");
////    }
//
//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                null,
//                null,
//                null,
//                null,
//                null,
//                null,
//                true)
//                ;
//    }
//}
