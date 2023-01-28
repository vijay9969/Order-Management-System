package com.orders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Product {

	 	@Id
	    @Column(name = "productId")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long productId;

	 	private  String productName;

	 	private String productDescription;

	 	private double unitPrice;

	    @ManyToOne
	    @JoinColumn(name = "orderId")
	    private OrderDetails orderDetails;

		public Product(String productName, String productDescription, double unitPrice, OrderDetails orderDetails) {
			super();
			this.productName = productName;
			this.productDescription = productDescription;
			this.unitPrice = unitPrice;
			this.orderDetails = orderDetails;
		}
	    
}
