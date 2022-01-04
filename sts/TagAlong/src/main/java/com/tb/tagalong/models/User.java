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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name="users")
	public class User {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="Name is required!")
	    @Size(min=2, max=30, message="Name must be between 2 and 30 characters")
	    private String name;
	    
	    @NotEmpty(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotEmpty(message="Password is required!")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	    private String confirm;
	    
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
	    //Many to many
	    //=========================
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    		name = "users_fav_trips",
	    		joinColumns = @JoinColumn(name = "user_id"),
	    		inverseJoinColumns = @JoinColumn(name = "trip_id")
	    	)
	    private List<Trip> favtrips;
	    
	    //========================
	    //One to many
	    //=========================
	    @OneToMany(mappedBy ="user", fetch=FetchType.LAZY)
	    private List<Trip> trips;
	    
	    
	    //Constructors
	    public User() {}
		public User(
				@NotEmpty(message = "Name is required!") @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters") String name,
				@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
				@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password) {
			this.name = name;
			this.email = email;
			this.password = password;
		}
		
		//getters and setters
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirm() {
			return confirm;
		}
		public void setConfirm(String confirm) {
			this.confirm = confirm;
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
		public List<Trip> getTrips() {
			return trips;
		}
		public void setTrips(List<Trip> trips) {
			this.trips = trips;
		}
		public List<Trip> getFavtrips() {
			return favtrips;
		}
		public void setFavtrips(List<Trip> favtrips) {
			this.favtrips = favtrips;
		}
	
		
		
}