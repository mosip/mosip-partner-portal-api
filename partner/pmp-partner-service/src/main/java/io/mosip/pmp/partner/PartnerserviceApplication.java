package io.mosip.pmp.partner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author sanjeev.shrivastava
 *
 */

@SpringBootApplication
@ComponentScan({ "io.mosip.pmp.*", "io.mosip.kernel.auth.adapter.*"})
@EnableSwagger2
public class PartnerserviceApplication{

	public static void main(String[] args) {
		SpringApplication.run(PartnerserviceApplication.class, args);
	}
}
