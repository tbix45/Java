package com.tb.tagalong.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="trips")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="Trip name is required!")
    @Size(min=2, max=50, message="Trip name must be between 2 and 50 characters")
    private String name;
    
    @NotEmpty(message="Location is required!")
    @Size(min=2, max=100, message="Location must be between 2 and 100 characters")
    private String location;
    
    @NotNull(message="Must have a start date!")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date startDate;
    
//    @NotNull(message="Must have a end date!")
   	@DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date endDate;
    
    @NotEmpty(message="Description is required!")
    @Size(min=2, max=300, message="Description must be between 2 and 300 characters")
    private String description;
    
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
    //Many to Many
    //==========================
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name = "users_fav_trips",
    		joinColumns = @JoinColumn(name = "trip_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    
    //========================
    //Many to one
    //==========================
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    //========================
    //Constructors
    //==========================  
    public Trip() {}

	public Trip(
			@NotEmpty(message = "Trip name is required!") @Size(min = 2, max = 50, message = "Trip name must be between 2 and 50 characters") String name,
			@NotEmpty(message = "Location is required!") @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters") String location,
			@NotEmpty(message = "Must have a start date!") Date startDate, Date endDate,
			@NotEmpty(message = "Description is required!") @Size(min = 2, max = 300, message = "Description must be between 2 and 300 characters") String description,
			User user) {
		this.name = name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
    
    
	
	
	
	
	
}
