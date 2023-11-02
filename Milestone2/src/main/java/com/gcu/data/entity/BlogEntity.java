package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("BLOG")
public class BlogEntity {
	@Id
	Long id;
	
	@Column("TITLE")
	String title;
	
	@Column("AUTHOR")
	String author;
	
	@Column("SUBTITLE")
	String subtitle;
	
	@Column("CONTENT")
	String content;
	
	@Column("DATE")
	String date;

	

	public BlogEntity(Long id, String title, String author, String subtitle, String content, String date) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.subtitle = subtitle;
		this.content = content;
		this.date = date;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getSubtitle() {
		return subtitle;
	}



	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}

	
	
	
}
