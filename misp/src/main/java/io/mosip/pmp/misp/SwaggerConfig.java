package io.mosip.pmp.misp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("io.mosip.pmp.misp"))
				.paths(regex("/.*")).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfo("MISP Services", "MISP", "1.0",
				"MISP of service",
				new Contact("MISP", "https://mosip.io", "info@mosip.io"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());	
	}
}
