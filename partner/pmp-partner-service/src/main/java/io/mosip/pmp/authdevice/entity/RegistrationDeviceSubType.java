package io.mosip.pmp.authdevice.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="reg_device_sub_type")
public class RegistrationDeviceSubType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@AttributeOverrides({
			@AttributeOverride(name = "code", column = @Column(name = "code", nullable = false,length = 36)),
			@AttributeOverride(name = "deviceType", column = @Column(name = "dtyp_code", nullable = false,length = 36)) })
	private String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dtyp_code", referencedColumnName = "code", insertable = false, updatable = false)
	private RegistrationDeviceType deviceType;
	
	@Column(name="name",length=64,nullable=false)
	private String name;
	
	@Column(name="desc",length=512,nullable=false)
	private String desciption;
	
	@Column(name="is_active",nullable=false)
	private boolean isActive;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name="cr_by",length=256,nullable=false)
	private String crBy;

	@Column(name="cr_dtimes",nullable=false)
	private LocalDateTime crDtimes;

	@Column(name="del_dtimes")
	private LocalDateTime delDtimes;
	
	@Column(name="upd_by",length=256)
	private String updBy;

	@Column(name="upd_dtimes")
	private LocalDateTime updDtimes;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public RegistrationDeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(RegistrationDeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCrBy() {
		return crBy;
	}

	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}

	public LocalDateTime getCrDtimes() {
		return crDtimes;
	}

	public void setCrDtimes(LocalDateTime crDtimes) {
		this.crDtimes = crDtimes;
	}

	public LocalDateTime getDelDtimes() {
		return delDtimes;
	}

	public void setDelDtimes(LocalDateTime delDtimes) {
		this.delDtimes = delDtimes;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public LocalDateTime getUpdDtimes() {
		return updDtimes;
	}

	public void setUpdDtimes(LocalDateTime updDtimes) {
		this.updDtimes = updDtimes;
	}
	
}
