package com.ethanmotaco.InventoryManagerBackend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductQuantityKey implements Serializable {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "product_id")
    private Long productId;
    
	public ProductQuantityKey() {
	}

	/**
	 * @param storeId
	 * @param productId
	 */
	public ProductQuantityKey(Long storeId, Long productId) {
		this.storeId = storeId;
		this.productId = productId;
	}

	

	/**
	 * @return the storeId
	 */
	public Long getStoreId() {
		return storeId;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductQuantityKey [storeId=" + storeId + ", productId=" + productId + "]";
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
        ProductQuantityKey other = (ProductQuantityKey) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (storeId == null) {
            if (other.storeId != null)
                return false;
        } else if (!storeId.equals(other.storeId))
            return false;
        return true;
    }

}