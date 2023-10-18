// Emmanuel
package com.gcu.model;

import jakarta.validation.constraints.NotNull;

public class BlogModel {
	
	@NotNull(message="Title is a required field")
	private String title;
	
	@NotNull(message="Subtitle is a required field")
	private String subtitle;
	
	@NotNull(message="Content is a required field")
	private String content;
	
	@NotNull(message="Author is a required field")
	private String author; 
	
	@NotNull(message="Date is a required field")
	private String date;

	public BlogModel(@NotNull(message = "Title is a required field") String title,
			@NotNull(message = "Subtitle is a required field") String subtitle,
			@NotNull(message = "Content is a required field") String content,
			@NotNull(message = "Author is a required field") String author,
			@NotNull(message = "Date is a required field") String date) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.author = author;
		this.date = date;
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
