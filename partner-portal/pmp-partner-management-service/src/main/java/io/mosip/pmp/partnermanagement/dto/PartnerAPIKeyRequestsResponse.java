package io.mosip.pmp.partnermanagement.dto;

import java.util.List;

import lombok.Data;

@Data
public class PartnerAPIKeyRequestsResponse {
	
	private List<ApikeyRequests> apikeyRequests;
}
