package io.mosip.pmp.policy.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the auth_policy database table.
 * 
 */
/**
 * @author Nagarjuna Kuchi
 *
 */
@Entity
@Table(name="auth_policy")
@NamedQuery(name="AuthPolicy.findAll", query="SELECT a FROM AuthPolicy a")
public class AuthPolicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="cr_by")
	private String crBy;

	@Column(name="cr_dtimes")
	private LocalDateTime crDtimes;

	@Column(name="del_dtimes")
	private LocalDateTime delDtimes;

	private String descr;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	private String name;

	@Column(name="policy_file_id")
	private String policyFileId;

	@Column(name="upd_by")
	private String updBy;

	@Column(name="upd_dtimes")
	private LocalDateTime updDtimes;
	
	@Column(name="policy_group_id")
	private String policy_group_id;

	public AuthPolicy() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrBy() {
		return this.crBy;
	}

	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}

	public LocalDateTime getCrDtimes() {
		return this.crDtimes;
	}

	public void setCrDtimes(LocalDateTime crDtimes) {
		this.crDtimes = crDtimes;
	}

	public LocalDateTime getDelDtimes() {
		return this.delDtimes;
	}

	public void setDelDtimes(LocalDateTime delDtimes) {
		this.delDtimes = delDtimes;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolicyFileId() {
		return this.policyFileId;
	}
	
	public String getPolicy_group_id() {
		return this.policy_group_id;
	}

	public void setPolicyFileId(String policyFileId) {
		this.policyFileId = policyFileId;
	}

	public String getUpdBy() {
		return this.updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public LocalDateTime getUpdDtimes() {
		return this.updDtimes;
	}

	public void setUpdDtimes(LocalDateTime updDtimes) {
		this.updDtimes = updDtimes;
	}
	
	public void setPolicy_group_id(String policy_group_id) {
		this.policy_group_id = policy_group_id;
	}

}