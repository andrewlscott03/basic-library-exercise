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
@Table(name = "resourcetype", schema = "public")
public class ResourceType implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String resourceType;
	@JsonIgnore
	private List<Resource> resources = new ArrayList<Resource>(0);

	public ResourceType() {
	}

	public ResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public ResourceType(String resourceType, List<Resource> resources) {
		this.resourceType = resourceType;
		this.resources = resources;
	}

	@Id
	@Column(name = "resourcetype", unique = true, nullable = false, length = 25)
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resourceType")
	public List<Resource> getResources() {
		return this.resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
