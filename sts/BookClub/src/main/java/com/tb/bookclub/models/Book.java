package com.tb.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="Title is required!")
    @Size(min=2, max=30, message="Title must be between 2 and 30 characters")
    private String title;

    @NotEmpty(message="Author is required!")
    @Size(min=2, max=30, message="Author must be between 2 and 30 characters")
    private String author;
    
    @NotEmpty(message="Thoughts is required!")
    @Size(min=2, max=30, message="Thoughts must be between 2 and 30 characters")
    private String thoughts;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    //========================
    //Many to one
    //==========================
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    
    //========================
    //Constructors
    //==========================
    public Book() {}
    
	public Book(
			@NotEmpty(message = "Title is required!") @Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters") String title,
			@NotEmpty(message = "Author is required!") @Size(min = 2, max = 30, message = "Author must be between 2 and 30 characters") String author,
			@NotEmpty(message = "Thoughts is required!") @Size(min = 2, max = 30, message = "Thoughts must be between 2 and 30 characters") String thoughts,
			User user) {
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
		this.user = user;
	}
    //========================
    //Getters and setters
    //==========================
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
	public String getThoughts() {
		return thoughts;
	}
	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
	
    
}
