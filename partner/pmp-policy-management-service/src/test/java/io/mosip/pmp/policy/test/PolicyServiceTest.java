/**
 * 
 */
package io.mosip.pmp.policy.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.mosip.pmp.common.helper.WebSubPublisher;

/**
 * @author Nagarjuna
 *
 */
@Import(value = {WebSubPublisher.class})
@SpringBootApplication(scanBasePackages = "io.mosip.pmp.policy.*")
public class PolicyServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PolicyServiceTest.class, args);

	}

}
