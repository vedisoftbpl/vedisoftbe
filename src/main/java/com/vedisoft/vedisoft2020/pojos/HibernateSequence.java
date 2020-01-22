package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the hibernate_sequences database table.
 * 
 */
@Entity
@Table(name="hibernate_sequences")
@NamedQuery(name="HibernateSequence.findAll", query="SELECT h FROM HibernateSequence h")
public class HibernateSequence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sequence_name", unique=true, nullable=false, length=255)
	private String sequenceName;

	@Column(name="sequence_next_hi_value")
	private BigInteger sequenceNextHiValue;

	public HibernateSequence() {
	}

	public String getSequenceName() {
		return this.sequenceName;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	public BigInteger getSequenceNextHiValue() {
		return this.sequenceNextHiValue;
	}

	public void setSequenceNextHiValue(BigInteger sequenceNextHiValue) {
		this.sequenceNextHiValue = sequenceNextHiValue;
	}

}