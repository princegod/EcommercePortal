package com.ecommerce.security;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ecommerce.domain.AbstractEntity;
import com.ecommerce.domain.User;

@Entity
public class UserRole extends AbstractEntity {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="roleId")
	private Role role;
	
	public UserRole(User user,Role role) {
		this.user=user;
		this.role=role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
