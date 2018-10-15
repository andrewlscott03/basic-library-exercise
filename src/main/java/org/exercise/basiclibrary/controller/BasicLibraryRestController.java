package org.exercise.basiclibrary.controller;

import java.util.List;
import java.util.Optional;

import org.basiclibrary.db.hibernate.Borrower;
import org.basiclibrary.db.hibernate.Loan;
import org.basiclibrary.db.repository.BorrowerRepository;
import org.basiclibrary.db.repository.ResourceRepository;
import org.basiclibrary.rest.model.Loans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicLibraryRestController {
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	BorrowerRepository borrowerRepository;
    
    @RequestMapping("/loansJson")
    public Loans getLoans(@RequestParam(value="borrowerId", required=true) String borrowerId) {
    	
    	Optional<Borrower> borrowerResult = borrowerRepository.findById(borrowerId);
    	if (borrowerResult.isPresent()) {
    		List<Loan> loanList = borrowerResult.get().getLoans();
    		return new Loans(loanList);
    	} else {
    		return new Loans(null);
    	}
    }
}
