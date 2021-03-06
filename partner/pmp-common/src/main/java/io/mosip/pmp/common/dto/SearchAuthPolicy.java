package io.mosip.pmp.common.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SearchAuthPolicy  {


	private String id;

	private String crBy;

	private Timestamp crDtimes;

	private LocalDateTime delDtimes;

	private String descr;

	private Boolean isActive;

	private Boolean isDeleted;

	private String name;

	private String policyFileId;

	private String updBy;

	private LocalDateTime updDtimes;
	private LocalDateTime validFromDate;

	private LocalDateTime validToDate;

	private String version;

	private String policyType;

	private String schema;

	private String policyGroup;

	public String getCrBy() {
		return crBy;
	}

	public Timestamp getCrDtimes() {
		return crDtimes;
	}

	public LocalDateTime getDelDtimes() {
		return delDtimes;
	}

	public String getDescr() {
		return descr;
	}

	public String getId() {
		return id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public String getName() {
		return name;
	}

	public String getPolicyFileId() {
		return policyFileId;
	}

	public String getPolicyGroup() {
		return policyGroup;
	}

	public String getPolicyType() {
		return policyType;
	}

	public String getSchema() {
		return schema;
	}

	public String getUpdBy() {
		return updBy;
	}

	public LocalDateTime getUpdDtimes() {
		return updDtimes;
	}

	public LocalDateTime getValidFromDate() {
		return validFromDate;
	}

	public LocalDateTime getValidToDate() {
		return validToDate;
	}

	public String getVersion() {
		return version;
	}

	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}

	public void setCrDtimes(Timestamp crDtimes) {
		this.crDtimes = crDtimes;
	}

	public void setDelDtimes(LocalDateTime delDtimes) {
		this.delDtimes = delDtimes;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPolicyFileId(String policyFileId) {
		this.policyFileId = policyFileId;
	}

	public void setPolicyGroup(String policyGroup) {
		this.policyGroup = policyGroup;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public void setUpdDtimes(LocalDateTime updDtimes) {
		this.updDtimes = updDtimes;
	}

	public void setValidFromDate(LocalDateTime validFromDate) {
		this.validFromDate = validFromDate;
	}

	public void setValidToDate(LocalDateTime validToDate) {
		this.validToDate = validToDate;
	}

	
	public void setVersion(String version) {
		this.version = version;
	}

}
