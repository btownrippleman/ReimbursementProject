package com.ex.reimbursement.domain;
import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	private Long id;
	private Double amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private Blob receipt;
	private Long author;
	private Long resolver;
	private Long status_id;
	private Long type_id;
	
	
	
	public Reimbursement(Long id, Double amount, Date submitted, Date resolved, String description, Blob receipt,
			Long author, Long resolver, Long status_id, Long type_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
	}
	public Reimbursement() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
	public Long getResolver() {
		return resolver;
	}
	public void setResolver(Long resolver) {
		this.resolver = resolver;
	}
	public Long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}
	public Long getType_id() {
		return type_id;
	}
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	
	
	
	
	

}
