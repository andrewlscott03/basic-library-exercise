package org.basiclibrary.db.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "loan", schema = "public")
public class Loan implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long loanId;
	@JsonIgnoreProperties("loans")
	private Borrower borrower;
	@JsonIgnoreProperties("loans")
	private Resource resource;
	private Date borrowed;
	private Date returned;

	public Loan() {
	}

	public Loan(long loanId, Borrower borrower, Resource resource, Date borrowed) {
		this.loanId = loanId;
		this.borrower = borrower;
		this.resource = resource;
		this.borrowed = borrowed;
	}

	public Loan(long loanId, Borrower borrower, Resource resource, Date borrowed, Date returned) {
		this.loanId = loanId;
		this.borrower = borrower;
		this.resource = resource;
		this.borrowed = borrowed;
		this.returned = returned;
	}

	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "loanIdgen", name = "LoanIDGen")
	@Id
	@Column(name = "loanId", unique = true, nullable = false, precision = 18, scale = 0)
	public long getLoanId() {
		return this.loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "borrowerId", nullable = false)
	public Borrower getBorrower() {
		return this.borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resourceId", nullable = false)
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "borrowed", nullable = false, length = 29)
	public Date getBorrowed() {
		return this.borrowed;
	}

	public void setBorrowed(Date borrowed) {
		this.borrowed = borrowed;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "returned", length = 29)
	public Date getReturned() {
		return this.returned;
	}

	public void setReturned(Date returned) {
		this.returned = returned;
	}
}
