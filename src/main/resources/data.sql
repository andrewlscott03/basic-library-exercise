INSERT INTO borrower(borrower_id, firstname, lastname, address, phone, mobile, email) 
	VALUES ('B00000001', 'Bob', 'Smith', '12 Branch st, Garden City, QLD', '07 1111 2222', '0416 111 222', 'bob.smith@someorg.com.au');
	
INSERT INTO borrower(borrower_id, firstname, lastname, address, phone, mobile, email) 
	VALUES ('B00000002', 'Jane', 'Smith', '12 Branch st, Garden City, QLD', '07 1111 2222', '0416 222 333', 'jane.smith@someorg.com.au');
	
INSERT INTO borrower(borrower_id, firstname, lastname, address, phone, mobile, email) 
	VALUES ('B00000003', 'Fran', 'Jacobs', '34 Tree st, Garden City, QLD', '07 2222 3333', '0416 333 444', 'fran.jacobs@someorg.com.au');
	
INSERT INTO borrower(borrower_id, firstname, lastname, address, phone, mobile, email) 
	VALUES ('B00000004', 'Joseph', 'Banks', '18 Fern st, Garden City, QLD', '07 3333 4444', '0416 4444 5555', 'joe.banks@someorg.com.au');


INSERT INTO resource(resource_id, resourcename, isbn, categoryname, resourcetype, author) 
	VALUES ('R00000001', 'So Long, and Thanks for All the Fish', '0-330-28498-3', 'Fiction', 'Book', 'Douglas Adams');
	
INSERT INTO resource(resource_id, resourcename, isbn, categoryname, resourcetype, author) 
	VALUES ('R00000002', 'Manassas', '1-58182-008-9', 'Fiction', 'Book', 'James Reasoner');

INSERT INTO resource(resource_id, resourcename, isbn, categoryname, resourcetype, author) 
	VALUES ('R00000003', 'The Children of Húrin', '0007322585', 'Fiction', 'Book', ' J. R. R. Tolkien');

INSERT INTO resource(resource_id, resourcename, isbn, categoryname, resourcetype, author) 
	VALUES ('R00000004', 'The Hobbit', '0007322607', 'Fiction', 'Book', ' J. R. R. Tolkien');
	
	
INSERT INTO loan(loan_id, borrower_id, resource_id, borrowed, returned)
    VALUES (nextval('LoanIdGen'), 'B00000001', 'R00000001', '2018-01-01', null);
    
INSERT INTO loan(loan_id, borrower_id, resource_id, borrowed, returned)
    VALUES (nextval('LoanIdGen'), 'B00000001', 'R00000002', '2018-01-01', '2018-01-03');
    
INSERT INTO loan(loan_id, borrower_id, resource_id, borrowed, returned)
    VALUES (nextval('LoanIdGen'), 'B00000003', 'R00000003', '2018-01-13', '2018-01-15');
    
INSERT INTO loan(loan_id, borrower_id, resource_id, borrowed, returned)
    VALUES (nextval('LoanIdGen'), 'B00000004', 'R00000004', '2018-01-07', '2018-01-18');
