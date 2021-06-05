package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {
	@Id
	@GeneratedValue
	@Column(name = "expense_id")
	private int expenseId;
	@Column(name = "item_name")
	private String itemName;
	private float price;
	@Column(name = "purchase_date")
	private String purchaseDate;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Expense() {
		
	}
	
	public Expense(int expenseId) {
		super();
		this.expenseId = expenseId;
	}

	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return expenseId + " " + itemName + " " + price + " "
				+ purchaseDate;
	}
	
}
