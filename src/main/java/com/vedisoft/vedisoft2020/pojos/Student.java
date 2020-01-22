package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="registration_id", unique=true, nullable=false)
	private int registrationId;

	@Column(length=20)
	private String branch;

	@Column(length=20)
	private String campus;

	@Column(name="card_no")
	private int cardNo;

	@Column(length=20)
	private String company;

	@Column(length=20)
	private String course;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Temporal(TemporalType.DATE)
	private Date doj;

	@Column(length=40)
	private String email;

	@Column(name="enquiry_id")
	private int enquiryId;

	@Column(length=120)
	private String extra3;

	@Column(name="father_name", length=45)
	private String fatherName;

	@Column(length=20)
	private String flag;

	@Column(length=100)
	private String laddress;

	@Column(name="last_updated_by", length=20)
	private String lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updation_date")
	private Date lastUpdationDate;

	@Column(length=20)
	private String mno;

	@Column(length=40)
	private String name;

	@Column(length=20)
	private String package1;

	@Column(length=100)
	private String paddress;

	@Column(name="parent_occupation", length=45)
	private String parentOccupation;

	@Column(length=20)
	private String password;

	@Column(length=255)
	private String pno;

	@Column(name="reg_id", length=145)
	private String regId;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	@Column(length=20)
	private String sem;

	@Column(name="whatsapp_no", length=20)
	private String whatsappNo;

	//bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branchBean;

	//bi-directional many-to-one association to CollegeList
	@ManyToOne
	@JoinColumn(name="college_id")
	private CollegeList collegeList;

	public Student() {
	}

	public int getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public int getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return this.doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnquiryId() {
		return this.enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getExtra3() {
		return this.extra3;
	}

	public void setExtra3(String extra3) {
		this.extra3 = extra3;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLaddress() {
		return this.laddress;
	}

	public void setLaddress(String laddress) {
		this.laddress = laddress;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdationDate() {
		return this.lastUpdationDate;
	}

	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}

	public String getMno() {
		return this.mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackage1() {
		return this.package1;
	}

	public void setPackage1(String package1) {
		this.package1 = package1;
	}

	public String getPaddress() {
		return this.paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getParentOccupation() {
		return this.parentOccupation;
	}

	public void setParentOccupation(String parentOccupation) {
		this.parentOccupation = parentOccupation;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPno() {
		return this.pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getSem() {
		return this.sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getWhatsappNo() {
		return this.whatsappNo;
	}

	public void setWhatsappNo(String whatsappNo) {
		this.whatsappNo = whatsappNo;
	}

	public Branch getBranchBean() {
		return this.branchBean;
	}

	public void setBranchBean(Branch branchBean) {
		this.branchBean = branchBean;
	}

	public CollegeList getCollegeList() {
		return this.collegeList;
	}

	public void setCollegeList(CollegeList collegeList) {
		this.collegeList = collegeList;
	}

}