package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the installment database table.
 * 
 */
@Entity
@Table(name="installment")
@NamedQuery(name="Installment.findAll", query="SELECT i FROM Installment i")
public class Installment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	private float amt;

	@Column(length=20)
	private String bank;

	private float cgst;

	@Temporal(TemporalType.DATE)
	@Column(name="chq_date")
	private Date chqDate;

	@Column(name="chq_no")
	private int chqNo;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="inst_date")
	private Date instDate;

	@Column(name="last_created_by")
	private int lastCreatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_creation_date")
	private Date lastCreationDate;

	@Column(length=20)
	private String mode1;

	@Column(name="receipt_no")
	private int receiptNo;

	@Column(name="reg_no", length=45)
	private String regNo;

	private float sgst;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id", nullable=false)
	private Batch batch;

	//bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name="branch_id", nullable=false)
	private Branch branch;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="staff_id", nullable=false)
	private Person person;

	public Installment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmt() {
		return this.amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public float getCgst() {
		return this.cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public Date getChqDate() {
		return this.chqDate;
	}

	public void setChqDate(Date chqDate) {
		this.chqDate = chqDate;
	}

	public int getChqNo() {
		return this.chqNo;
	}

	public void setChqNo(int chqNo) {
		this.chqNo = chqNo;
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

	public Date getInstDate() {
		return this.instDate;
	}

	public void setInstDate(Date instDate) {
		this.instDate = instDate;
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

	public String getMode1() {
		return this.mode1;
	}

	public void setMode1(String mode1) {
		this.mode1 = mode1;
	}

	public int getReceiptNo() {
		return this.receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getRegNo() {
		return this.regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public float getSgst() {
		return this.sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}