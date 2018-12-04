package com.ecommerce.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.ecommerce.domain.AbstractEntity;

@Entity
public class Role extends AbstractEntity implements Serializable{

	private static final long serialVersionUID=89993289L;
	private String roleName;
	@OneToMany(mappedBy="role",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<UserRole> userRole=new HashSet<>();
	private boolean active;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
