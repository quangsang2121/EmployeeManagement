package com.sang.ManageEmployee.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
	private static final long serialVersionUID = 12345435L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long id;
	
	@NotNull
	@Column(length = 15)
	private String username;
	
	@Column(length = 50)
	private String name;
	
	@NotNull
	@Column(name = "password",length = 100)
	private String password;

}
