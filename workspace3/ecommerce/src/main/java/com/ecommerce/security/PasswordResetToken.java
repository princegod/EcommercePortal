package com.ecommerce.security;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ecommerce.domain.AbstractEntity;
import com.ecommerce.domain.User;

@Entity
public class PasswordResetToken extends AbstractEntity{

	private static final int EXPIRATION=60*24;
	
	private String token;
	private Date expiryDate;

	@OneToOne(targetEntity=User.class,fetch=FetchType.EAGER)
	@JoinColumn(nullable=false,name="userId")
	private User user;
	
	public PasswordResetToken(final String token,final User user) {
		super();
		this.token=token;
		this.user=user;
		this.expiryDate=calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());;
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}
	
	public void updateToken(final String token) {
		this.token=token;
		this.expiryDate=calculateExpiryDate(EXPIRATION);
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}
	
	
	
	
}
