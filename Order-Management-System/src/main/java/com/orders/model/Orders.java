package com.orders.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString

@Entity
public class Orders {
	 	@Id
	    @Column(name = "order_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderId;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @OneToMany
	    private List<OrderDetails> orderDetails;

	    private double totalAmount;
	    
	    private double discount;

		public Orders(Customer customer, List<OrderDetails> orderDetails, double totalAmount) {
			super();
			this.customer = customer;
			this.orderDetails = orderDetails;
			this.totalAmount = totalAmount;
			
			if(customer.getCategory().equals("gold")) {
				this.discount = totalAmount*10/100;
			}else if(customer.getCategory().equals("platinum")) {
				this.discount = totalAmount*20/100;
			}else {
				this.discount = 0;
			}
		}
	
}
