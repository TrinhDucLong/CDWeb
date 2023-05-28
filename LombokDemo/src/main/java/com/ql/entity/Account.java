package com.ql.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	
	@Id
    @NotBlank(message = "user name not emty")
	@NotEmpty(message = "user name not emty")
	@Column(columnDefinition = "varchar(30)")
	@Size(min = 4 , message = "username must be greater than or equal to 4 ")
	private String username;
	
	@NotEmpty(message = "password not emty")
	@Size(min = 6 , message = "Password must be greater than or equal to 6 ")
	@Column(columnDefinition = "nvarchar(30)")
	private String password;
	@NotEmpty(message = "fullname not emty")
	@Column(columnDefinition = "nvarchar(30)")
	@Size(min = 6 , message = "username must be greater than or equal to 6 ")
	private String fullname;
	@NotEmpty(message = "email not emty")
	@Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@Column(columnDefinition = "nvarchar(30)")
	private String email;
	@Column(columnDefinition = "nvarchar(30)")
	private String photo;
	private Boolean activated;
	private Boolean admin;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders; 
	

}
