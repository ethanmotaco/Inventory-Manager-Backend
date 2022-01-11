package com.ethanmotaco.InventoryManagerBackend.model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class InboundLog  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String store;
	private Long storeId;
	private String product;
	private Long productId;
	private int quantity;
	private String timestamp;
	
	public InboundLog() {
		super();
	}

	/**
	 * @param id
	 * @param store
	 * @param storeId
	 * @param product
	 * @param productId
	 * @param quantity
	 * @param timestamp
	 */
	public InboundLog(Long id, String store, Long storeId, String product, Long productId, int quantity,
			String timestamp) {
		super();
		this.id = id;
		this.store = store;
		this.storeId = storeId;
		this.product = product;
		this.productId = productId;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the store
	 */
	public String getStore() {
		return store;
	}

	/**
	 * @return the storeId
	 */
	public Long getStoreId() {
		return storeId;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(String store) {
		this.store = store;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	
}
