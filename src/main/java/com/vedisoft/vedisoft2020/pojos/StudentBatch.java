package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the student_batch database table.
 * 
 */
@Entity
@Table(name="student_batch")
@NamedQuery(name="StudentBatch.findAll", query="SELECT s FROM StudentBatch s")
public class StudentBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sb_id", unique=true, nullable=false)
	private Long sbId;

	@Column(length=45)
	private String certificate;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	@Column(length=20)
	private String flag;

	@Column(nullable=false, length=45)
	private String joined;

	@Column(name="last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="student_id", length=200)
	private String studentId;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	public StudentBatch() {
	}

	public long getSbId() {
		return this.sbId;
	}

	public void setSbId(long sbId) {
		this.sbId = sbId;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getJoined() {
		return this.joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public int getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "StudentBatch [sbId=" + sbId + ", certificate=" + certificate + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", flag=" + flag + ", joined=" + joined + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", studentId=" + studentId + ", batch="
				+ batch + "]";
	}
	
	

}