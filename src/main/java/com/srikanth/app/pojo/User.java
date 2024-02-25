package com.srikanth.app.pojo;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;
@NamedQuery(name="User.findByEmailId", query="select u from User u where u.email=:email")
@DynamicUpdate
@DynamicInsert
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Cont_Name")
	private String contactNumber;
	@Column(name = "PassWord")
	private String password;
	@Column(name = "Email")
	private String email;
	@Column(name = "Status")
	private String status;
	@Column(name = "Role")
	private String role;

}
