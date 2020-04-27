package io.mosip.pmp.misp.dto;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Nagarjuna Kuchi
 * @version 1.0
 * 
 * Defines an object to hold the misp status update request details.
 *
 */

@Data
@ApiModel(value = "MISPStatusUpdateRequestDto" , description = "MISP Status update request representation")
public class MISPStatusUpdateRequestDto {

	@Size(min= 0, max = 20)
	@ApiModelProperty(value ="mispStatus", required = true, dataType = "java.lang.String")
	private String mispStatus;
	
	private String mispId;
}
