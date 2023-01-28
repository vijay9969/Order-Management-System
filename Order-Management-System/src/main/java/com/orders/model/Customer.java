package com.orders.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private Long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String country;
	private String category;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "oderId")
	@JoinTable(name = "customer_order", joinColumns = {@JoinColumn(name = "customerId")}, inverseJoinColumns = {@JoinColumn(name = "orderId")})
	private Set<Orders> orders = new HashSet<Orders>();
	
	public Customer(String firstName, String lastName, String email, String phone, String city, String state,
			String country, Set<Orders> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.country = country;
		this.orders = orders;
		if(orders.size()==9) {
			sendMail();
		}else if(orders.size()>9&&orders.size()<20) {
			this.category = "gold";
		}else if(orders.size()>19) {
			this.category = "platinum";
		}else {
		this.category = "regular";
		}
	}
	
	
	public Customer() {
		if(this.orders.size()==9) {
			sendMail();
		}else if(this.orders.size()>9&&this.orders.size()<20) {
			this.category = "gold";
		}else if(this.orders.size()>19) {
			this.category = "platinum";
		}else {
			this.category = "regular";
		}
		
	}
		static void sendMail() {
		System.out.println("Sent mail to customer");
		}
	
	

}
