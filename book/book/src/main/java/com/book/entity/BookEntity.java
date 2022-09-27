package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String name;
    private String author;
    private String category;
    private String publisher;
    private double price;
    private String emailId;// emailid
    private String subscriptionId; //1-subscribe , 0-unsubscribe
    private int block;
    public BookEntity() {
        super();
        // TODO Auto-generated constructor stub
    }
    public BookEntity(String name, String author, String category, String publisher, double price, String emailId,
            String subscriptionId, int block) {
        super();
        this.name = name;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.price = price;
        this.emailId = emailId;
        this.subscriptionId = subscriptionId;
        this.block = block;
    }
    public BookEntity(int bookId, String name, String author, String category, String publisher, double price, String emailId,
            String subscriptionId, int block) {
        this(name,author,category,publisher,price,emailId,subscriptionId,block);
        this.bookId=bookId;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getSubscriptionId() {
        return subscriptionId;
    }
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    public int getBlock() {
        return block;
    }
    public void setBlock(int block) {
        this.block = block;
    }
}	