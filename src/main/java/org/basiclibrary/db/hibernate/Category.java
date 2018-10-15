package org.basiclibrary.db.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category", schema = "public")
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	@JsonIgnore
	private List<Resource> resources = new ArrayList<Resource>(0);

	public Category() {
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category(String categoryName, List<Resource> resources) {
		this.categoryName = categoryName;
		this.resources = resources;
	}

	@Id
	@Column(name = "categoryname", unique = true, nullable = false, length = 25)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public List<Resource> getResources() {
		return this.resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
