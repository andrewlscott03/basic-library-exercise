--
-- Table structure for table `authors`
-- 


-- --------------------------------------------------------


--
-- Borrowers
--
-- This table is used to identify the borrowers who borrower resources.
--

create table Borrower(
	Borrower_ID character(9) not null,
	FirstName varchar(25) default null,
	LastName varchar(25) default null,
	Address varchar(255) default null,
	Phone varchar(15) default null,
	Mobile varchar(15) default null,
	Email varchar(255) default null,
	primary key (Borrower_ID)
);


-- --------------------------------------------------------


--
-- Category
--
-- A list of the resource categories.  This field is used for a drop
-- down list.
--

create table Category(
	CategoryName varchar(25) not null,
	primary key ( CategoryName )
);

insert into Category
values ( 'Fiction' );

insert into Category
values ( 'Health & Lifestyle' );

insert into Category
values ( 'Family & Personal' );

insert into Category
values ( 'Biographical' );

insert into Category
values( 'News' );

insert into Category
values( 'Children' );

insert into Category
values( 'History' );



-- --------------------------------------------------------

--
-- ResourceType
--
-- A list of the types of the valid resources.
--

create table ResourceType(
	ResourceType varchar(25) not null,
	primary key ( ResourceType )
);

insert into ResourceType
values( 'Book' );

insert into ResourceType
values( 'Blu-ray' );

insert into ResourceType
values( 'CD' );

insert into ResourceType
values( 'DVD' );


-- --------------------------------------------------------


-- Resource
-- Used to describe a resource.

create table Resource(
	Resource_ID character(9) not null,
	ResourceName varchar(255) not null,
	ISBN character(13), -- isbn 10
	CategoryName varchar(25) not null,
	ResourceType varchar(25) not null,
	Author varchar(75),
	primary key (Resource_ID),
	foreign key (CategoryName) references Category (CategoryName),
	foreign key (ResourceType) references ResourceType (ResourceType)
);


-- --------------------------------------------------------


--
-- Loan
--
-- Used to identify the loan of a single resource.
--

create table Loan(
	Loan_ID decimal(18,0) not null,
	Borrower_ID varchar(9) not null,
	Resource_ID varchar(9) not null,
	Borrowed timestamp not null,
	Returned timestamp,
	primary key  (Loan_ID),
	foreign key (Borrower_ID) references Borrower (Borrower_ID),
	foreign key (Resource_ID) references Resource (Resource_ID)
);

create index LoanBorrowedIdx on Loan( Borrowed );
create index LoanReturnedIdx on Loan( Returned );
   
create sequence LoanIdGen increment 1 start 1 minvalue 1;
create sequence BorrowerIdgen increment 1 start 1 minvalue 1;
create sequence ResourceIdgen increment 1 start 1 minvalue 1;

commit;