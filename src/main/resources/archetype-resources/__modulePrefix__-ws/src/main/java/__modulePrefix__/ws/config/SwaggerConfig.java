package ${groupId}.${modulePrefix}.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Config
 */
@Configuration
@EnableSwagger2
@ComponentScan("${groupId}")
public class SwaggerConfig {

    /**
     * Api
     * 
     * @return Docket
     */
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("${rootArtifactId}-api")
                    .select()
                    .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                    .build()
                .apiInfo(apiInfo())
                    .tags(new Tag("${rootArtifactId}", "${rootArtifactId}."));
    }

    private static ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("${rootArtifactId}")
                .description("${rootArtifactId}")
                .version("1.0")
                .contact(new Contact("Vinicius Antonio Gai.", "https://github.com/viniciustoni/", "viniciustoni@gmail.com"))
                .build();
    }

}
