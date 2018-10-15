<!doctype html>
<html lang="en">
	<head>
		<#include "header.ftl">
	</head>
	<body>
		<#include "banner.ftl">
		
		<div id="loans" v-cloak class="d-flex flex-row bd-highlight mb-2">
			<div class="container">
				<h3>People</h3>
				<ul class="list-group">
					<#list borrowerList as borrower>
					<a @click="getLoans('${borrower.borrowerId}')"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${borrower.firstname} ${borrower.lastname}</h5>
						</div>
						<p class="mb-1">${borrower.address}</p>
						<p class="mb-1">${borrower.phone}</p>
						<p class="mb-1">${borrower.mobile}</p>
						<p class="mb-1">${borrower.email}</p>
					</a>
					</#list>
				</ul>
			</div>
			<div class="container">
				<h3>Borrowed Resources</h3>
				<div v-for="loan in loans" class="loan">
					{{loan.resource.resourceName}}<br/>
				</div>
	
				<div v-if="noResults">
					No resources have been borrowed by this person.
				</div>
	
				<div v-if="searching">
					<i>Searching...</i>
				</div>
			</div>
		</div>
		
		<script src="loans.js"></script>
		
	</body>
</html>