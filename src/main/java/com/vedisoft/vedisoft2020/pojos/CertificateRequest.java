package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the certificate_request database table.
 * 
 */
@Entity
@Table(name="certificate_request")
@NamedQuery(name="CertificateRequest.findAll", query="SELECT c FROM CertificateRequest c")
public class CertificateRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String addedby;

	@Column(name="batch_code")
	private int batchCode;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="delivered_date")
	private Date deliveredDate;

	@Column(name="delivered_to_contactno", length=200)
	private String deliveredToContactno;

	@Column(name="delivered_to_name", length=200)
	private String deliveredToName;

	@Column(name="delivery_status", length=20)
	private String deliveryStatus;

	@Column(name="last_created_by")
	private int lastCreatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_creation_date")
	private Date lastCreationDate;

	@Column(length=20)
	private String prepared;

	@Column(length=20)
	private String regno;

	@Temporal(TemporalType.DATE)
	@Column(name="request_date")
	private Date requestDate;

	//bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;

	public CertificateRequest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddedby() {
		return this.addedby;
	}

	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}

	public int getBatchCode() {
		return this.batchCode;
	}

	public void setBatchCode(int batchCode) {
		this.batchCode = batchCode;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeliveredDate() {
		return this.deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getDeliveredToContactno() {
		return this.deliveredToContactno;
	}

	public void setDeliveredToContactno(String deliveredToContactno) {
		this.deliveredToContactno = deliveredToContactno;
	}

	public String getDeliveredToName() {
		return this.deliveredToName;
	}

	public void setDeliveredToName(String deliveredToName) {
		this.deliveredToName = deliveredToName;
	}

	public String getDeliveryStatus() {
		return this.deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public int getLastCreatedBy() {
		return this.lastCreatedBy;
	}

	public void setLastCreatedBy(int lastCreatedBy) {
		this.lastCreatedBy = lastCreatedBy;
	}

	public Date getLastCreationDate() {
		return this.lastCreationDate;
	}

	public void setLastCreationDate(Date lastCreationDate) {
		this.lastCreationDate = lastCreationDate;
	}

	public String getPrepared() {
		return this.prepared;
	}

	public void setPrepared(String prepared) {
		this.prepared = prepared;
	}

	public String getRegno() {
		return this.regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}