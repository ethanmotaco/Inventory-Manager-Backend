package com.ethanmotaco.InventoryManagerBackend.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PreUpdate;

@Entity
public class ProductQuantity {

	    @EmbeddedId
	    ProductQuantityKey id;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @MapsId("storeId")
	    @JoinColumn(name = "store_id")
	    private Store store;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @MapsId("productId")
	    @JoinColumn(name = "product_id")
	    private Product product;

	    private int quantity;

	    public ProductQuantity() {
	    }

	    @PreUpdate
	    public void onPreUpdate() {
	    	
	    }

		/**
		 * @return the id
		 */
		public ProductQuantityKey getId() {
			return id;
		}

		/**
		 * @return the store
		 */
		public Store getStore() {
			return store;
		}

		/**
		 * @return the product
		 */
		public Product getProduct() {
			return product;
		}

		/**
		 * @return the quantity
		 */
		public int getQuantity() {
			return quantity;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(ProductQuantityKey id) {
			this.id = id;
		}

		/**
		 * @param store the store to set
		 */
		public void setStore(Store store) {
			this.store = store;
		}

		/**
		 * @param product the product to set
		 */
		public void setProduct(Product product) {
			this.product = product;
		}

		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "ProductQuantity [id=" + id + ", store=" + store + ", product=" + product + ", quantity=" + quantity
					+ "]";
		}
		
		@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        ProductQuantity other = (ProductQuantity) obj;
	        if (id == null) {
	            if (other.id != null)
	                return false;
	        } else if (!id.equals(other.id))
	            return false;
	        return true;
	    }
	    
	    
	}
