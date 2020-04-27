package io.mosip.pmp.partnermanagement.dto;

import lombok.Data;

@Data
public class RetrievePartnersDetails {
	
	private String partnerID;
	private String status;
	private String organizationName;
	private String contactNumber;
	private String emailId;
	private String address;

}
