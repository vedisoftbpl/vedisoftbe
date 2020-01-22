package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the college_list database table.
 * 
 */
@Entity
@Table(name="college_list")
@NamedQuery(name="CollegeList.findAll", query="SELECT c FROM CollegeList c")
public class CollegeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String city;

	@Column(length=45)
	private String group;

	@Column(length=80)
	private String name;

	@Column(length=20)
	private String prefix;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="collegeList")
	private List<Student> students;

	public CollegeList() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setCollegeList(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setCollegeList(null);

		return student;
	}

}