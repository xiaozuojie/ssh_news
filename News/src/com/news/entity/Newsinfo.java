package com.news.entity;

import java.util.Date;

/**
 * Newsinfo entity. @author MyEclipse Persistence Tools
 */

public class Newsinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Topic topic;
	private String title;
	private String author;
	private Date createDate;
	private String content;
	private String summary;

	// Constructors

	/** default constructor */
	public Newsinfo() {
	}

	/** full constructor */
	public Newsinfo(Topic topic, String title, String author,
			Date createDate, String content, String summary) {
		this.topic = topic;
		this.title = title;
		this.author = author;
		this.createDate = createDate;
		this.content = content;
		this.summary = summary;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}