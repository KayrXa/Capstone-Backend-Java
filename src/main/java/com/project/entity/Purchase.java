package com.project.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="purchases")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private LocalDate purchasedate = LocalDate.now();
	private String createdby;
	private double totalprice;
	
	@JsonIgnoreProperties("purchase")
	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private List<Item> items;
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(String createdby, double totalprice) {
		super();
		this.createdby = createdby;
		this.totalprice = totalprice;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public LocalDate getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(LocalDate purchasedate) {
		this.purchasedate = purchasedate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		items.forEach(item -> item.setPurchase(this));
	}
	
}