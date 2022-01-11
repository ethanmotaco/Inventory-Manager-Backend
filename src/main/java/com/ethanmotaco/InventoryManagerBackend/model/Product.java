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
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	protected String name;
	protected String description;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<ProductQuantity> quantities;
	
	public Product() {
		super();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
