package com.tb.tvshows.models;

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
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="Show name is required!")
    @Size(min=2, max=30, message="Show name must be between 2 and 50 characters")
    private String name;

    @NotEmpty(message="Network is required!")
    @Size(min=2, max=30, message="Network must be between 2 and 30 characters")
    private String network;
    
    @NotEmpty(message="Description is required!")
    @Size(min=2, max=300, message="Description must be between 2 and 300 characters")
    private String description;
    
//    @NotEmpty(message="Rating is required!")
//	@DecimalMin(value="0.00")
//	@DecimalMax(value="5.0", message="Can't be more than 5 stars!")
//	private Double rating;
    
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
    public Show() {}
//	public Show(
//			@NotEmpty(message = "Show name is required!") @Size(min = 2, max = 30, message = "Show name must be between 2 and 50 characters") String name,
//			@NotEmpty(message = "Network is required!") @Size(min = 2, max = 30, message = "Network must be between 2 and 30 characters") String network,
//			@NotEmpty(message = "Rating is required!") @DecimalMin("0.00") @DecimalMax(value = "5.0", message = "Can't be more than 5 stars!") Double rating,
//			User user) {
//		this.name = name;
//		this.network = network;
//		this.description = description;
////		this.rating = rating;
//		this.user = user;
//	}
	
	  public Show(
			@NotEmpty(message = "Show name is required!") @Size(min = 2, max = 30, message = "Show name must be between 2 and 50 characters") String name,
			@NotEmpty(message = "Network is required!") @Size(min = 2, max = 30, message = "Network must be between 2 and 30 characters") String network,
			@NotEmpty(message = "Description is required!") @Size(min = 2, max = 30, message = "Description must be between 2 and 300 characters") String description,
			User user) {
		this.name = name;
		this.network = network;
		this.description = description;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
//	public Double getRating() {
//		return rating;
//	}
//	public void setRating(Double rating) {
//		this.rating = rating;
//	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    

    
    
    
    
    
    
}
