package com.kenya.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name ="travelExpense")
public class Expense {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
// ========================= Table columns ===== ==================
	 
	 // --- ExpenseName---- 
	@NotNull
	@Size( min=1, message="Expense name must not be blank " )
	private String name;
	 
	 // ------ Vendor -------
	@NotNull
	@Size( min=1, message="Vendor cannot be left empty " )
	private String vendor;
	
	// ------- Amount -------- 
	@NotNull
	@Min(value=0, message="Amount must be greater than 0")
	private Integer cost;
	
	// ------ Description -----
	@NotNull
	@Size( min=1, message="Description must not be blank " )
	private String description;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
	// Constructor just for chill vibezzz 
	public Expense() {
		
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
// ================================= GETTERS & SETTERS ==========================
	
	// ------ Get expense Name ------
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	// ------ Set expense Name ------
	public void setName(String name) {
		this.name = name;
	}

	// ------ Get vendor ------
	public String getVendor() {
		return vendor;
	}
	// ------ Set vendor  ------
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	// ------ Get amount ------
	public Integer getCost() {
		return cost;
	}
	// ------ Set amount ------
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	// ------ Get description  ------
	public String getDescription() {
		return description;
	}
	// ------ Set description ------
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
