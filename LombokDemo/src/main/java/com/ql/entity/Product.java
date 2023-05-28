package com.ql.entity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// tu dong tang id
	private Integer id;
	@Column(columnDefinition = "nvarchar(255)")
	@NotBlank(message = "name product not emty")
	@NotEmpty(message = "name product not emty")
	private String name;
	private String image;
	@Column(columnDefinition = "nvarchar(255)")
	@NotEmpty(message = "name product not emty")
	private String titleProduct;
	@Column(columnDefinition = "nvarchar(255)")
	@NotEmpty(message = "name product not emty")
	private String descriptionProduct;
	private Double price;
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	private Date createDate = new Date();
	private Boolean availble;
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;

}
