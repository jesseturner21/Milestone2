// Emmanuel
package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BlogModel {
	
	private int id;
	
	@NotNull(message="Title is a required field")
	@Size(min=1, message="Title must have at least one character")
	private String title;
	
	@NotNull(message="Author is a required field")
	@Size(min=1, message="Author must have at least one character")
	private String author; 
	
	@NotNull(message="Subtitle is a required field")
	@Size(min=1, message="Subtitle must have at least one character")
	private String subtitle;
	
	@NotNull(message="Content is a required field")
	@Size(min=1, message="Content must have at least one character")
	private String content;
	
	@NotNull(message="Date is a required field")
	@Size(min=1, message="Date must have at least one character")
	private String date;
	
	public BlogModel() {
		// default constructor
	}

	public BlogModel(int id, @NotNull(message = "Title is a required field") String title,
			@NotNull(message = "Subtitle is a required field") String subtitle,
			@NotNull(message = "Content is a required field") String content,
			@NotNull(message = "Author is a required field") String author,
			@NotNull(message = "Date is a required field") String date) {
		super();
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.author = author;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 
	
}
