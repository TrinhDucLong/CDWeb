package com.ql.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderDetails", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"OrDerid","Productid"})
}
)
public class OrderDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double price;
	private Integer quantity;
	@ManyToOne @JoinColumn(name = "OrDerid")
	private Order order;
	@ManyToOne @JoinColumn(name = "Productid")
	private Product product;


}
