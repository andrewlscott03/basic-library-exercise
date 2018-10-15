package org.exercise.basiclibrary.utils;

import java.util.List;

import org.basiclibrary.db.hibernate.Borrower;
import org.basiclibrary.db.hibernate.Category;
import org.basiclibrary.db.hibernate.Loan;
import org.basiclibrary.db.hibernate.Resource;
import org.basiclibrary.db.hibernate.ResourceType;
import org.basiclibrary.rest.model.Loans;
import org.junit.Assert;

public class AssertUtils {
	
	public static void assertEquals(final String msg, final Borrower expected, final Borrower actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }

	    Assert.assertEquals(msg + ".Borrower.borrowerId", expected.getBorrowerId(), actual.getBorrowerId());
	    Assert.assertEquals(msg + ".Borrower.firstname", expected.getFirstname(), actual.getFirstname());
	    Assert.assertEquals(msg + ".Borrower.lastname", expected.getLastname(), actual.getLastname());
	    Assert.assertEquals(msg + ".Borrower.address", expected.getAddress(), actual.getAddress());
	    Assert.assertEquals(msg + ".Borrower.phone", expected.getPhone(), actual.getPhone());
	    Assert.assertEquals(msg + ".Borrower.mobile", expected.getMobile(), actual.getMobile());
	    Assert.assertEquals(msg + ".Borrower.email", expected.getEmail(), actual.getEmail());
	    Assert.assertEquals(msg + ".Borrower.loans", expected.getLoans(), actual.getLoans());
	}

	public static void assertEquals(final String msg, final Resource expected, final Resource actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }

	    Assert.assertEquals(msg + ".Resource.resourceId", expected.getResourceId(), actual.getResourceId());
	    assertEquals(msg + ".Resource.category", expected.getCategory(), actual.getCategory());
	    assertEquals(msg + ".Resource.resourceType", expected.getResourceType(), actual.getResourceType());
	    Assert.assertEquals(msg + ".Resource.resourceName", expected.getResourceName(), actual.getResourceName());
	    Assert.assertEquals(msg + ".Resource.isbn", expected.getIsbn(), actual.getIsbn());
	    Assert.assertEquals(msg + ".Resource.author", expected.getAuthor(), actual.getAuthor());
	    Assert.assertEquals(msg + ".Resource.loans", expected.getLoans(), actual.getLoans());
	}
	
	public static void assertEquals(final String msg, final Loan expected, final Loan actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }

	    Assert.assertEquals(msg + ".Loan.loanId", expected.getLoanId(), actual.getLoanId());
	    assertEquals(msg + ".Loan.borrower", expected.getBorrower(), actual.getBorrower());
	    assertEquals(msg + ".Loan.resource", expected.getResource(), actual.getResource());
	    Assert.assertEquals(msg + ".Loan.borrowed", expected.getBorrowed(), actual.getBorrowed());
	    Assert.assertEquals(msg + ".Loan.returned", expected.getReturned(), actual.getReturned());
	}

	public static void assertEquals(final String msg, final Category expected, final Category actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }

	    Assert.assertEquals(msg + ".Category.categoryName", expected.getCategoryName(), actual.getCategoryName());
	    Assert.assertEquals(msg + ".Category.resources", expected.getResources(), actual.getResources());
	}

	public static void assertEquals(final String msg, final ResourceType expected, final ResourceType actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }

	    Assert.assertEquals(msg + ".ResourceType.resourceType", expected.getResourceType(), actual.getResourceType());
	    Assert.assertEquals(msg + ".ResourceType.resources", expected.getResources(), actual.getResources());
	}
	
	public static void assertEquals(final String msg, final Loans expected, final Loans actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }
	    
	    Assert.assertEquals(msg + ".Loans.loanCount", expected.getLoanCount(), actual.getLoanCount());
	    assertEqualsLoanList(msg + ".Loans.loans", expected.getLoans(), actual.getLoans());
	}

	public static void assertEqualsLoanList(final String msg, final List<Loan> expected, final List<Loan> actual) {

	    if (expected == actual) {

	        return;
	    }

	    if ((expected == null) || (actual == null)) {

	        Assert.assertEquals(msg, expected, actual);
	    }
	    
	    Assert.assertEquals(msg + ".size()", expected.size(), actual.size());
	    for (int index = 0; index < expected.size(); index++) {
	    	Loan expectedElem = expected.get(index);
	    	Loan actualElem = actual.get(index);
	    	assertEquals(msg + "[" + index + "]", expectedElem, actualElem);
	    }
	}

}
