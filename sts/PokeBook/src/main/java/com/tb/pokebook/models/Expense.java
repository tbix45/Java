package com.tb.pokebook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="expenses")
public class Expense {
	
	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=200, message="Expense must be between 2 and 200 characters long!")
	private String expense;
	
	@NotNull
	@Size(min=2, max=200, message="Vendor must be between 2 and 200 characters long!")
	private String vendor;
	
	@NotNull(message="Must not be empty!")
	@DecimalMin(value="0.01", message="Must be greater than 0!")
	@DecimalMax(value="100", message="You are spending to much!")
	private Double amount;
	
	@NotNull
	@Size(min=2, max=200, message="Description must be between 2 and 200 characters long!")
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
    
    //constructors
    public Expense() {}
    
	public Expense(
			@NotNull @Size(min = 2, max = 200, message = "Expense must be between 2 and 200 characters long!") String expense,
			@NotNull @Size(min = 2, max = 200, message = "Vendor must be between 2 and 200 characters long!") String vendor,
			@NotNull(message = "Must not be empty!") @DecimalMin("0.01") @DecimalMax("100") Double amount) {

		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
	}
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    


}
