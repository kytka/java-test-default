package com.etnetera.hr.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 * 
 * @author Etnetera
 *
 */
@Entity
@Table(name = "framework")
public class JavaScriptFramework {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@OneToMany(mappedBy = "framework")
	private List<FrameworkVersion> versionList = new ArrayList<>();

	public void addVersion(FrameworkVersion version){
		versionList.add(version);
	}

	public void removeVersion(FrameworkVersion version){
		versionList.remove(version);
	}

	public JavaScriptFramework() {
		//TODO this.name = "no name provided";
	}

	public JavaScriptFramework(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FrameworkVersion> getVersionList() {
		return versionList;
	}

	public void setVersionList(List<FrameworkVersion> versionList) {
		this.versionList = versionList;
	}

	@Override
	public String toString() {
		return "JavaScriptFramework [id=" + id + ", name=" + name + "]";
	}

}
