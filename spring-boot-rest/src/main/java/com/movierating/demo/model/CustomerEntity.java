package com.movierating.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TBL_CUSTOMER")
public class CustomerEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	
	@Column(name="custName")
    private String custName;
	
	@Transient
	private Double avgRating;
	
	public CustomerEntity() {
		
	}
	
	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public CustomerEntity(String custName) {
		this.custName = custName;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Override
	public String toString() {
		return "CustomerEntity [custId=" + custId + ", custName=" + custName + ", avgRating=" + avgRating + "]";
	}
	
}
