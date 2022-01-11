package com.ethanmotaco.InventoryManagerBackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.ethanmotaco.InventoryManagerBackend.model.ProductQuantity;
import com.ethanmotaco.InventoryManagerBackend.model.ProductQuantityKey;

public interface ProductQuantityRepository  extends JpaRepository<ProductQuantity, ProductQuantityKey> {
	
	@Transactional
	int deleteByStoreIdAndProductId(Long storeId, Long productId);
	
	@Transactional
	int deleteProductQuantitiesByStore_Id(Long storeId);
	
	@Transactional
	int deleteProductQuantitiesByProduct_Id(Long productId);
	
	List<ProductQuantity> findProductQuantitiesByStore_Id(Long storeId);

}