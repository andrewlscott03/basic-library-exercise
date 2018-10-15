package org.basiclibrary.rest.model;

import java.util.List;

import org.basiclibrary.db.hibernate.Loan;

public class Loans {

	private int loanCount;
	private List<Loan> loans;
	
	public Loans() {};
	
	public Loans(List<Loan> loanList) {
		if (loanList == null) {
			this.loanCount = 0;
		} else {
			this.loanCount = loanList.size();
		}
		this.loans = loanList;
	}
	
	public int getLoanCount() {
		return loanCount;
	}
	
	public List<Loan> getLoans() {
		return loans;
	}
}
