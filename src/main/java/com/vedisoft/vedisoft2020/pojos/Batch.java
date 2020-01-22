package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the batch database table.
 * 
 */
@Entity
@Table(name="batch")
@NamedQuery(name="Batch.findAll", query="SELECT b FROM Batch b")
public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="batch_id", unique=true, nullable=false)
	private int batchId;

	@Column(name="branch_id")
	private int branchId;

	@Column(length=45)
	private String code;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Column(length=20)
	private String days;

	@Column(length=20)
	private String enddate;

	@Column(name="faculty_id")
	private int facultyId;

	@Column(name="last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updation_date")
	private Date lastUpdationDate;

	@Temporal(TemporalType.DATE)
	private Date sdate;

	@Column(length=20)
	private String status;

	@Column(length=20)
	private String timings;

	//bi-directional one-to-one association to Branch
	@OneToOne
	@JoinColumn(name="batch_id", nullable=false, insertable=false, updatable=false)
	private Branch branch;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="session_id")
	private Session session;

	//bi-directional many-to-one association to Installment
	@OneToMany(mappedBy="batch")
	private List<Installment> installments;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="batch")
	private List<Fee> fees;

	//bi-directional one-to-one association to StudentBatch
	@OneToOne
	@JoinColumn(name="batch_id", referencedColumnName="batch_id", nullable=false, insertable=false, updatable=false)
	private StudentBatch studentBatch;

	public Batch() {
	}

	public int getBatchId() {
		return this.batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDays() {
		return this.days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getFacultyId() {
		return this.facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdationDate() {
		return this.lastUpdationDate;
	}

	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimings() {
		return this.timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Installment> getInstallments() {
		return this.installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	public Installment addInstallment(Installment installment) {
		getInstallments().add(installment);
		installment.setBatch(this);

		return installment;
	}

	public Installment removeInstallment(Installment installment) {
		getInstallments().remove(installment);
		installment.setBatch(null);

		return installment;
	}

	public List<Fee> getFees() {
		return this.fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setBatch(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setBatch(null);

		return fee;
	}

	public StudentBatch getStudentBatch() {
		return this.studentBatch;
	}

	public void setStudentBatch(StudentBatch studentBatch) {
		this.studentBatch = studentBatch;
	}

}