package io.mosip.pmp.partnermanagement.dto;

import lombok.Data;

@Data
public class ApikeyRequests {
	
	private String partnerID;
	private String status;
	private String organizationName;
	private String policyName;
	private String policyDesc;
	private String apiKeyReqNo;
}
