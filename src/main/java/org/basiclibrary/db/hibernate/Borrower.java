package org.basiclibrary.db.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "borrower", schema = "public")
public class Borrower implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String borrowerId;
	private String firstname;
	private String lastname;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	@JsonIgnoreProperties("borrower")
	private List<Loan> loans = new ArrayList<Loan>(0);

	public Borrower() {
	}

	public Borrower(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	public Borrower(String borrowerId, String firstname, String lastname, String address, String phone, String mobile,
			String email, List<Loan> loans) {
		this.borrowerId = borrowerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.loans = loans;
	}

	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "borrowerIdgen", name = "BorrowerIdGen")
	@GeneratedValue(generator = "BorrowerIdGen", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name = "BorrowerIdGen", strategy = "org.basiclibrary.db.hibernate.BorrowerIdCustomGen")
	@Id
	@Column(name = "borrower_id", unique = true, nullable = false, length = 9)
	public String getBorrowerId() {
		return this.borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	@Column(name = "firstname", length = 25)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 25)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "mobile", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "borrower")
	public List<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
}
