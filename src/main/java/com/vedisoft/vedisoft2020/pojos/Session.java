package com.vedisoft.vedisoft2020.pojos;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@Table(name="session")
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="session_id", unique=true, nullable=false)
	private Long sessionId;

	@Column(length=16)
	private String command;

	@Column(name="conn_id")
	private BigInteger connId;


	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Lob
	@Column(name="current_memory")
	private String currentMemory;



	@Lob
	@Column(name="current_statement")
	private String currentStatement;

	

	@Column(length=64)
	private String db;


	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(length=20)
	private String extra;

	@Column(name="full_scan", nullable=false, length=3)
	private String fullScan;

	

	@Lob
	@Column(name="last_statement")
	private String lastStatement;



	@Lob
	@Column(name="last_statement_latency")
	private String lastStatementLatency;

	

	@Column(name="last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updation_date")
	private Date lastUpdationDate;

	@Column(name="last_wait", length=128)
	private String lastWait;



	@Lob
	@Column(name="last_wait_latency")
	private String lastWaitLatency;



	@Lob
	@Column(name="lock_latency")
	private String lockLatency;



	@Column(length=1024)
	private String pid;

	

	@Column(name="program_name", length=1024)
	private String programName;



	@Column(precision=10, scale=2)
	private BigDecimal progress;

	

	@Column(name="rows_affected")
	private BigInteger rowsAffected;



	@Column(name="rows_examined")
	private BigInteger rowsExamined;

	

	@Column(name="rows_sent")
	private BigInteger rowsSent;



	@Column(name="session_name", length=20)
	private String sessionName;

	@Column(length=64)
	private String source;



	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(length=64)
	private String state;

	

	@Lob
	@Column(name="statement_latency")
	private String statementLatency;

	

	@Column(name="thd_id", nullable=false)
	private BigInteger thdId;


	private BigInteger time;

	

	@Column(name="tmp_disk_tables")
	private BigInteger tmpDiskTables;

	
	@Column(name="tmp_tables")
	private BigInteger tmpTables;


	@Column(name="trx_autocommit", length=1)
	private String trxAutocommit;


	@Lob
	@Column(name="trx_latency")
	private String trxLatency;

	

	@Column(name="trx_state", length=1)
	private String trxState;

	@Column(length=288)
	private String user;

	

	//bi-directional many-to-one association to Batch
	@OneToMany(mappedBy="session")
	private List<Batch> batches;

	public Session() {
	}

	public Long getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	
	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setConnId(BigInteger connId) {
		this.connId = connId;
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


	public String getCurrentMemory() {
		return this.currentMemory;
	}

	public void setCurrentMemory(String currentMemory) {
		this.currentMemory = currentMemory;
	}


	public String getCurrentStatement() {
		return this.currentStatement;
	}

	public void setCurrentStatement(String currentStatement) {
		this.currentStatement = currentStatement;
	}


	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getExtra() {
		return this.extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}


	public String getFullScan() {
		return this.fullScan;
	}

	public void setFullScan(String fullScan) {
		this.fullScan = fullScan;
	}


	public String getLastStatement() {
		return this.lastStatement;
	}

	public void setLastStatement(String lastStatement) {
		this.lastStatement = lastStatement;
	}


	public String getLastStatementLatency() {
		return this.lastStatementLatency;
	}

	public void setLastStatementLatency(String lastStatementLatency) {
		this.lastStatementLatency = lastStatementLatency;
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


	public String getLastWait() {
		return this.lastWait;
	}

	public void setLastWait(String lastWait) {
		this.lastWait = lastWait;
	}


	public String getLastWaitLatency() {
		return this.lastWaitLatency;
	}

	public void setLastWaitLatency(String lastWaitLatency) {
		this.lastWaitLatency = lastWaitLatency;
	}

	public String getLockLatency() {
		return this.lockLatency;
	}

	public void setLockLatency(String lockLatency) {
		this.lockLatency = lockLatency;
	}


	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public BigDecimal getProgress() {
		return this.progress;
	}

	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}






	public String getSessionName() {
		return this.sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}


	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getStatementLatency() {
		return this.statementLatency;
	}

	public void setStatementLatency(String statementLatency) {
		this.statementLatency = statementLatency;
	}




	public void setTime(BigInteger time) {
		this.time = time;
	}



	public void setTmpDiskTables(BigInteger tmpDiskTables) {
		this.tmpDiskTables = tmpDiskTables;
	}


	public void setTmpTables(BigInteger tmpTables) {
		this.tmpTables = tmpTables;
	}



	public String getTrxAutocommit() {
		return this.trxAutocommit;
	}

	public void setTrxAutocommit(String trxAutocommit) {
		this.trxAutocommit = trxAutocommit;
	}


	public String getTrxLatency() {
		return this.trxLatency;
	}

	public void setTrxLatency(String trxLatency) {
		this.trxLatency = trxLatency;
	}


	public String getTrxState() {
		return this.trxState;
	}

	public void setTrxState(String trxState) {
		this.trxState = trxState;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Batch> getBatches() {
		return this.batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public Batch addBatch(Batch batch) {
		getBatches().add(batch);
		batch.setSession(this);

		return batch;
	}

	public Batch removeBatch(Batch batch) {
		getBatches().remove(batch);
		batch.setSession(null);

		return batch;
	}

}