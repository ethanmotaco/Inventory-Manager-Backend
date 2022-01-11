package com.ethanmotaco.InventoryManagerBackend.model;

public class InventoryItem extends Product{
	private int quantity;

	/**
	 * 
	 */
	public InventoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param description
	 * @param quantity
	 */
	public InventoryItem(String name, String description, int quantity) {
		super(name, description);

		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryItem [quantity=" + quantity + ", name=" + name + ", description=" + description + "]";
	}
	
}
