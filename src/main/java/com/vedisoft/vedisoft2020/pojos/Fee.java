package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fees database table.
 * 
 */
@Entity
@Table(name="fees")
@NamedQuery(name="Fee.findAll", query="SELECT f FROM Fee f")
public class Fee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date")
	private Date dueDate;

	@Column(length=20)
	private String extra1;

	private int extra2;

	private float famt;

	@Column(name="last_creation_by")
	private int lastCreationBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_creation_date")
	private Date lastCreationDate;

	@Column(length=20)
	private String mode1;

	//bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	public Fee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getExtra1() {
		return this.extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public int getExtra2() {
		return this.extra2;
	}

	public void setExtra2(int extra2) {
		this.extra2 = extra2;
	}

	public float getFamt() {
		return this.famt;
	}

	public void setFamt(float famt) {
		this.famt = famt;
	}

	public int getLastCreationBy() {
		return this.lastCreationBy;
	}

	public void setLastCreationBy(int lastCreationBy) {
		this.lastCreationBy = lastCreationBy;
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

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}