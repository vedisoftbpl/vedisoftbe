package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="certi_title", length=1000)
	private String certiTitle;

	private int duration;

	@Column(length=20)
	private String name;

	@Column(length=20)
	private String prefix;

	//bi-directional many-to-one association to Batch
	@JsonIgnore
	@OneToMany(mappedBy="course")
	private List<Batch> batches;

	public Course() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertiTitle() {
		return this.certiTitle;
	}

	public void setCertiTitle(String certiTitle) {
		this.certiTitle = certiTitle;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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

	public List<Batch> getBatches() {
		return this.batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public Batch addBatch(Batch batch) {
		getBatches().add(batch);
		batch.setCourse(this);

		return batch;
	}

	public Batch removeBatch(Batch batch) {
		getBatches().remove(batch);
		batch.setCourse(null);

		return batch;
	}

}