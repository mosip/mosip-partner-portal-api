package io.mosip.pmp.policy.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * <p> Defines an object to provide user details from MOSIP as per the policy.</p>
 *  
 *  <p>
 *  Note: While creating auth policies allowedKycAttributes should contain parameters name as defined below.</br>
 *  attributeName, required.</br>
 *  ex: {"attributeName":"fullName","required":true}</br>
 *  </p>
 *  
 * @author Nagarjuna Kuchi
 * @version 1.0
 *
 */
@Data
public class AllowedKycDto {
    
	/**
	 * <p> A piece of information which determines the properties of a field or tag in a display. </p>
	 */
	@NotBlank(message = "attributeName should not be empty in allowedKyc.")
	public String attributeName;	
	/**
	 * Tells feature enable or disable.
	 */
	@NotBlank(message = "required should contain 'true' or 'false' values in allowedKyc.")
	public boolean required; 
}
