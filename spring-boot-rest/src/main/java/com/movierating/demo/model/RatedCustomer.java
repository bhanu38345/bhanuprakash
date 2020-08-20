package com.movierating.demo.model;

public class RatedCustomer {
	
	private Long custId;
	
	private Long count;
	
	private Double avgRating;
	
    public RatedCustomer(Long custId, Long count, Double avgRating) {
		
		this.custId = custId;
		this.count = count;
		this.avgRating = avgRating;
		
	}
    public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	@Override
	public String toString() {
		return "RatedCustomer [custId=" + custId + ", count=" + count + ", avgRating=" + avgRating + "]";
	}
	
}
