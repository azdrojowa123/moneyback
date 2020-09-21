package webservice.moneyback;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableCaching
public class SwaggerConfig {


    @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis( RequestHandlerSelectors.basePackage("webservice.moneyback"))
	            .paths(PathSelectors.any())
	            .build();
	}
    
    private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Moneyback API with Swagger")
            .contact(new Contact("Aleksandra Zdrojowa",
            					"website here",
                                "a.zdrojowa@gmail.com"))
            .build();
    }
    

    


 
}
