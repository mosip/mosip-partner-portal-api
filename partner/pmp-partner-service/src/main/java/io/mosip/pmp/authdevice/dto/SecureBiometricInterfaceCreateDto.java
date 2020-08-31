package io.mosip.pmp.authdevice.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class SecureBiometricInterfaceCreateDto {
	
	@NotNull
	@Size(min = 1, max = 36)
	@ApiModelProperty(value = "softBinaryHash", required = true, dataType = "java.lang.String")
	private String swBinaryHash;
	
	@NotNull
	@Size(min = 1, max = 64)
	@ApiModelProperty(value = "softwareVersion", required = true, dataType = "java.lang.String")
	private String swVersion;
	
	@NotNull
	@Size(min = 1, max = 36)
	@ApiModelProperty(value = "deviceDetailId", required = true, dataType = "java.lang.String")
	private String deviceDetailId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime swCreateDateTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime swExpiryDateTime;
	
	@NotNull
	@Size(min = 1, max = 36)
	@ApiModelProperty(value = "approvalStatus", required = true, dataType = "java.lang.String")
	private String approvalStatus;
	
	@NotNull
	private boolean isActive;

	public String getSwBinaryHash() {
		return swBinaryHash;
	}

	public void setSwBinaryHash(String swBinaryHash) {
		this.swBinaryHash = swBinaryHash;
	}

	public String getSwVersion() {
		return swVersion;
	}

	public void setSwVersion(String swVersion) {
		this.swVersion = swVersion;
	}

	public String getDeviceDetailId() {
		return deviceDetailId;
	}

	public void setDeviceDetailId(String deviceDetailId) {
		this.deviceDetailId = deviceDetailId;
	}

	public LocalDateTime getSwCreateDateTime() {
		return swCreateDateTime;
	}

	public void setSwCreateDateTime(LocalDateTime swCreateDateTime) {
		this.swCreateDateTime = swCreateDateTime;
	}

	public LocalDateTime getSwExpiryDateTime() {
		return swExpiryDateTime;
	}

	public void setSwExpiryDateTime(LocalDateTime swExpiryDateTime) {
		this.swExpiryDateTime = swExpiryDateTime;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}