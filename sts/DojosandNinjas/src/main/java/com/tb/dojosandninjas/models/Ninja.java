package com.tb.dojosandninjas.models;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {

	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=200, message="First name must be between 2 and 200 characters long!")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=200, message="Last name must be between 2 and 200 characters long!")
	private String lastName;
	
	@NotNull(message="Must not be empty!")
	@Min(value=1, message="Must be at least 1 year old!")
	@Max(value=100, message="Too old, sorry!")
	private Integer age;
	
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
    
    
    //======================
    //related data 1:n
    //======================
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;
	
    //=======================
    //constructors
    //=======================
    public Ninja() {}
    
	public Ninja(
			@NotNull @Size(min = 2, max = 200, message = "First name must be between 2 and 200 characters long!") String firstName,
			@NotNull @Size(min = 2, max = 200, message = "Last name must be between 2 and 200 characters long!") String lastName,
			@NotNull(message = "Must not be empty!") @Min(value = 1, message = "Must be at least 1 year old!") @Max(value = 100, message = "Too old, sorry!") Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
    
    //getters/setters
	public Dojo getDojo() {
		return dojo;
	}
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
    
    
    
}
