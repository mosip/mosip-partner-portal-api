package io.mosip.pmp.partnermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mosip.pmp.partnermanagement.entity.Partner;


/**
 * Repository class for create partner id.
 * @author sanjeev.shrivastava
 *
 */

@Repository
public interface PartnerRepository extends JpaRepository<Partner, String> {

	/**
	 * Method to fetch last updated partner id
	 * @param name partner name
	 * @return list of partner
	 */
	
	public List<Partner> findByName(String name);
}
