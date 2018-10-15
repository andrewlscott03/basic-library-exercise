package org.basiclibrary.db.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "resource", schema = "public")
public class Resource implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String resourceId;
	private Category category;
	private ResourceType resourceType;
	private String resourceName;
	private String isbn;
	private String author;
	@JsonIgnoreProperties("resource")
	private List<Loan> loans = new ArrayList<Loan>(0);

	public Resource() {
	}

	public Resource(String resourceId, Category category, ResourceType resourceType, String resourceName,
			String author) {
		this.resourceId = resourceId;
		this.category = category;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
	}

	public Resource(String resourceId, Category category, ResourceType resourceType, String resourceName, String isbn,
			String author, List<Loan> loans) {
		this.resourceId = resourceId;
		this.category = category;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.isbn = isbn;
		this.loans = loans;
	}

	@Id
	@Column(name = "resource_id", unique = true, nullable = false, length = 9)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryname", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resourcetype", nullable = false)
	public ResourceType getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name = "resourcename", nullable = false)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "isbn", length = 50)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "author", length = 75)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resource")
	public List<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
}
