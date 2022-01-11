package com.ethanmotaco.InventoryManagerBackend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Ethan Motaco
 *
 */
@Entity
public class Store implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String address;
	private String email;
	private String phone;
	@JsonIgnore
	@OneToMany(mappedBy = "store")
    List<ProductQuantity> quantities;
	
	public Store() {
		super();
	}

	/**
	 * @param name
	 * @param address
	 * @param email
	 * @param phone
	 */
	public Store(String name, String address, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	
	
	/**
	 * @return the quantities
	 */
	public List<ProductQuantity> getQuantities() {
		return quantities;
	}

	/**
	 * @param quantities the quantities to set
	 */
	public void setQuantities(List<ProductQuantity> quantities) {
		this.quantities = quantities;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
				+ phone + "]";
	}
}
