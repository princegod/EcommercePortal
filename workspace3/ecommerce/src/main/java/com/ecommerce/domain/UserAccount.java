package com.ecommerce.domain;

import javax.persistence.Entity;

@Entity
public class UserAccount {

	private Long id;
	private String userName;
	private String password;
	private String roleId;
	private String description;
	private boolean active;
	
}
