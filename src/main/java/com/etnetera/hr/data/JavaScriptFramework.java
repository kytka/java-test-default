package com.etnetera.hr.data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 * 
 * @author Etnetera
 *
 */
@Entity
public class JavaScriptFramework {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	private String version;

	private LocalDate deprecationDate;

	public enum HypeLevel {
		NOBODY_USES_IT,
		SOMEBODY_USES_IT,
		EVERYBODY_USES_IT
	}

	private HypeLevel hypeLevel = HypeLevel.NOBODY_USES_IT;

	public JavaScriptFramework() {
		//TODO this.name = "no name provided";
	}

	public JavaScriptFramework(String name) {
		this.name = name;
	}

	public JavaScriptFramework(String name, String version, LocalDate deprecationDate, HypeLevel hypeLevel) {
		this.name = name;
		this.version = version;
		this.deprecationDate = deprecationDate;
		this.hypeLevel = hypeLevel;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public LocalDate getDeprecationDate() {
		return deprecationDate;
	}

	public void setDeprecationDate(LocalDate deprecationDate) {
		this.deprecationDate = deprecationDate;
	}

	public HypeLevel getHypeLevel() {
		return hypeLevel;
	}

	public void setHypeLevel(HypeLevel hypeLevel) {
		this.hypeLevel = hypeLevel;
	}

	@Override
	public String toString() {
		return "JavaScriptFramework [id=" + id + ", name=" + name + "]";
	}

}
