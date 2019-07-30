package com.news.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set newsinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(String name, Set newsinfos) {
		this.name = name;
		this.newsinfos = newsinfos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getNewsinfos() {
		return this.newsinfos;
	}

	public void setNewsinfos(Set newsinfos) {
		this.newsinfos = newsinfos;
	}

}