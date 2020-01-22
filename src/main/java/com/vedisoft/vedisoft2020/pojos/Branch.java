package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the branches database table.
 * 
 */
@Entity
@Table(name="branches")
@NamedQuery(name="Branch.findAll", query="SELECT b FROM Branch b")
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="branch_id", unique=true, nullable=false)
	private int branchId;

	@Column(name="branch_contact_no", length=20)
	private String branchContactNo;

	@Column(name="branch_manager_id")
	private int branchManagerId;

	@Column(name="branch_name", length=20)
	private String branchName;

	@Column(name="branch_prefix", length=20)
	private String branchPrefix;

	@Column(length=20)
	private String city;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="estb_date")
	private Date estbDate;

	@Column(length=20)
	private String extra1;

	private int extra2;

	@Column(name="last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updation_date")
	private Date lastUpdationDate;

	@Column(length=45)
	private String lat;

	@Column(length=20)
	private String locality;

	@Column(name="long", length=45)
	private String long_;

	@Column(name="multiple_courses", length=1000)
	private String multipleCourses;

	@Column(name="plot_no", length=20)
	private String plotNo;

	@Column(length=20)
	private String state;

	@Column(length=20)
	private String street;

	//bi-directional one-to-one association to Batch
	@OneToOne(mappedBy="branch")
	private Batch batch;

	//bi-directional many-to-one association to CertificateRequest
	@OneToMany(mappedBy="branch")
	private List<CertificateRequest> certificateRequests;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="branch")
	private List<Fee> fees;

	//bi-directional many-to-one association to Installment
	@OneToMany(mappedBy="branch")
	private List<Installment> installments;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="branch")
	private List<Person> persons;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="branchBean")
	private List<Student> students;

	public Branch() {
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchContactNo() {
		return this.branchContactNo;
	}

	public void setBranchContactNo(String branchContactNo) {
		this.branchContactNo = branchContactNo;
	}

	public int getBranchManagerId() {
		return this.branchManagerId;
	}

	public void setBranchManagerId(int branchManagerId) {
		this.branchManagerId = branchManagerId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchPrefix() {
		return this.branchPrefix;
	}

	public void setBranchPrefix(String branchPrefix) {
		this.branchPrefix = branchPrefix;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Date getEstbDate() {
		return this.estbDate;
	}

	public void setEstbDate(Date estbDate) {
		this.estbDate = estbDate;
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

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLong_() {
		return this.long_;
	}

	public void setLong_(String long_) {
		this.long_ = long_;
	}

	public String getMultipleCourses() {
		return this.multipleCourses;
	}

	public void setMultipleCourses(String multipleCourses) {
		this.multipleCourses = multipleCourses;
	}

	public String getPlotNo() {
		return this.plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<CertificateRequest> getCertificateRequests() {
		return this.certificateRequests;
	}

	public void setCertificateRequests(List<CertificateRequest> certificateRequests) {
		this.certificateRequests = certificateRequests;
	}

	public CertificateRequest addCertificateRequest(CertificateRequest certificateRequest) {
		getCertificateRequests().add(certificateRequest);
		certificateRequest.setBranch(this);

		return certificateRequest;
	}

	public CertificateRequest removeCertificateRequest(CertificateRequest certificateRequest) {
		getCertificateRequests().remove(certificateRequest);
		certificateRequest.setBranch(null);

		return certificateRequest;
	}

	public List<Fee> getFees() {
		return this.fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setBranch(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setBranch(null);

		return fee;
	}

	public List<Installment> getInstallments() {
		return this.installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	public Installment addInstallment(Installment installment) {
		getInstallments().add(installment);
		installment.setBranch(this);

		return installment;
	}

	public Installment removeInstallment(Installment installment) {
		getInstallments().remove(installment);
		installment.setBranch(null);

		return installment;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setBranch(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setBranch(null);

		return person;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setBranchBean(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setBranchBean(null);

		return student;
	}

}