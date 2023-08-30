package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iid;
	private int mid;
	private int amount;
	private double ticketprice;
	
	@JsonIgnoreProperties("items")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pid")
	private Purchase purchase;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int mid, int amount, double ticketprice, Purchase purchase) {
		super();
		this.mid = mid;
		this.amount = amount;
		this.ticketprice = ticketprice;
		this.purchase = purchase;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
}