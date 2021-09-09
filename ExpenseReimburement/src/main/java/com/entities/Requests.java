package com.entities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="requests")
public class Requests {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="req_id")
	private int requestId;
	
	
	@Temporal(value = TemporalType.DATE)
	@Column (name="exp_date")
	private Date expenseDate;
	
	@Column (name="req_date")
	private Date requestedDate;
	
	
	private String category;
	private String merchant;
	
	@Column (name="amt")
	private double amount;
	private String memo;
	
	@Lob
	private byte[] receipt;
	@Column (name="approved_date")
	private Date approvedDate;
	private String status;
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="empId")
	private Employee employee;
	
	
	
	
	public Requests() {
		super();
		this.requestedDate = new Date();
		this.status = "Pending";
		this.comment = "Pending";		
	}




	public Requests(int requestId, Date expenseDate, Date requestedDate, String category, String merchant,
			double amount, String memo, byte[] receipt, Date approvedDate, String status, String comment,
			Employee employee) {
		super();
		this.requestId = requestId;
		this.expenseDate = expenseDate;
		this.requestedDate = requestedDate;
		this.category = category;
		this.merchant = merchant;
		this.amount = amount;
		this.memo = memo;
		this.receipt = receipt;
		this.approvedDate = approvedDate;
		this.status = status;
		this.comment = comment;
		this.employee = employee;
	}




	public int getRequestId() {
		return requestId;
	}




	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}




	public Date getExpenseDate() {
		return expenseDate;
	}




	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}




	public Date getRequestedDate() {
		return requestedDate;
	}




	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getMerchant() {
		return merchant;
	}




	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getMemo() {
		return memo;
	}




	public void setMemo(String memo) {
		this.memo = memo;
	}




	public byte[] getReceipt() {
		return receipt;
	}




	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}




	public Date getApprovedDate() {
		return approvedDate;
	}




	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getComment() {
		return comment;
	}




	public void setComment(String comment) {
		this.comment = comment;
	}




	public Employee getEmployee() {
		return employee;
	}




	public void setEmployee(Employee employee) {
		this.employee = employee;
	}




	@Override
	public String toString() {
		return "Requests [requestId=" + requestId + ", expenseDate=" + expenseDate + ", requestedDate=" + requestedDate
				+ ", category=" + category + ", merchant=" + merchant + ", amount=" + amount + ", memo=" + memo
				+ ", receipt=" + Arrays.toString(receipt) + ", approvedDate=" + approvedDate + ", status=" + status
				+ ", comment=" + comment + ", employee=" + employee + "]";
	}
	
}




		