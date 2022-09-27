package com.author.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Details {
	
	
	public int bookId;
	public int authorId;
	public String title;
	public String category;
	public double price;
	public String authorName;
	public String publisher;
	private boolean isBlocked=false;
	private LocalDate releasedDate;
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Details [bookId=" + bookId + ", authorId=" + authorId + ", title=" + title + ", category=" + category
				+ ", price=" + price + ", authorName=" + authorName + ", publisher=" + publisher + ", isBlocked="
				+ isBlocked + ", releasedDate=" + releasedDate + "]";
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	public LocalDate getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
	
	
	

}
