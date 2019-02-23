package br.com.caelum.avenger.avenger.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.caelum.avenger.avenger"))
					.paths(PathSelectors.ant("/api/**"))
//					.paths(PathSelectors.ant("/admin/**"))
					.build()
					.apiInfo(apiInfo())

	        		.globalResponseMessage(RequestMethod.GET, 
	        			Arrays.asList(
	        				new ResponseMessageBuilder()
	        					.code(500)
	        					.message("Xii! Deu erro interno no servidor.")
	        					.build(),
	        				new ResponseMessageBuilder()
	        					.code(403)
	        					.message("Forbidden! Você não pode acessar esse recurso.")
	        					.build(),
	        				new ResponseMessageBuilder()
	        					.code(404)
	        					.message("O recurso que você buscou não foi encontrado.")
	        					.build()))

			        //.ignoredParameterTypes(User.class)
					.globalOperationParameters(
						Arrays.asList(
							new ParameterBuilder()
								.name("Authorization")
								.description("Header para facilitar o envio do Authorization Bearer Token")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false)
								.build()));
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Shield", "", "contato@shield.com");
		
		return new ApiInfoBuilder()
							.title("Shield Avenger API Documentation")
							.description("This is the interactive documentation of Shield Avenger CRUD API. Please try send some requests.")
							.version("1.0")
							.contact(contact)
							.build();
	}
}
