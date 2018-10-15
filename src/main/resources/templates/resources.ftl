<!doctype html>
<html lang="en">
	<head>
		<#include "header.ftl">
	</head>
	<body>
		<#include "banner.ftl">
		<h3>Resources</h3>
		<div class="d-flex flex-row bd-highlight mb-2">
			<div class="container">
				<ul class="list-group">
					<#list resourceList as resource>
					<a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${resource.resourceName}</h5>
							<small class="text-muted">${resource.category.categoryName}
								${resource.resourceType.resourceType}</small>
						</div>
						<p class="mb-1">${resource.author}</p>
						<small class="text-muted">${resource.isbn}</small>
					</a>
					</#list>
				</ul>
			</div>
			<div class="container">
			</div>
		</div>
	</body>
</html>