package io.mosip.pmp.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.mosip.pmp.policy.entity.PolicyGroup;

/**
 * @author Nagarjuna Kuchi
 *
 */
public interface PolicyGroupRepository extends JpaRepository<PolicyGroup, String>{
	
		PolicyGroup findByName(String name);

}
