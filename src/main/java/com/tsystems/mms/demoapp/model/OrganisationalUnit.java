package com.tsystems.mms.demoapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tsystems.mms.demoapp.user.User;

@Entity
@Table(name = "organisational_unit")
public class OrganisationalUnit implements Serializable {

	private static final long serialVersionUID = 4360192521375330200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organisational_id", nullable = false)
	protected Long id;

	@Column(name = "organisational_unit_name", nullable = false)
	private String organisationalUnitName;

	@OneToMany
	@JoinColumn(name = "organisational_id")
	private List<User> user;

	public OrganisationalUnit() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganisationalUnitName() {
		return organisationalUnitName;
	}

	public void setOrganisationalUnitName(String organisationalUnitName) {
		this.organisationalUnitName = organisationalUnitName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}


	

}
