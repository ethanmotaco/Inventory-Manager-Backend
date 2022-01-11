package com.ethanmotaco.InventoryManagerBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ethanmotaco.InventoryManagerBackend.exception.ProductQuantityNotFoundException;
import com.ethanmotaco.InventoryManagerBackend.model.ProductQuantity;
import com.ethanmotaco.InventoryManagerBackend.model.ProductQuantityKey;
import com.ethanmotaco.InventoryManagerBackend.repository.ProductQuantityRepository;

@Service
public class ProductQuantityService {
private final ProductQuantityRepository productQuantityRepository;
	
	@Autowired
	public ProductQuantityService(ProductQuantityRepository productQuantityRepository) {
		this.productQuantityRepository = productQuantityRepository;
	}
	
	public ProductQuantity findProductQuantityById(ProductQuantityKey id) {
		return productQuantityRepository.findById(id)
				.orElseThrow(() -> new ProductQuantityNotFoundException ("Product Quantity with id " + id + " was not found"));
	}
	
	public List<ProductQuantity> findAllProductQuantities() {
		return productQuantityRepository.findAll();
	}
	
	public List<ProductQuantity> findProductQuantitiesByStoreId(Long storeId) {
		return productQuantityRepository.findProductQuantitiesByStore_Id(storeId);
	}
	
	public ProductQuantity addProductQuantity(ProductQuantity productQuantity) {
		return productQuantityRepository.save(productQuantity);
	}

	public int deleteProductQuantityByStoreIdAndProductId(Long storeId, Long productId) {
		return productQuantityRepository.deleteByStoreIdAndProductId(storeId, productId);
	}
	
	public int deleteProductQuantitiesByStoreId(Long storeId) {
		return productQuantityRepository.deleteProductQuantitiesByStore_Id(storeId);
	}
	
	public int deleteProductQuantitiesByProductId(Long productId) {
		return productQuantityRepository.deleteProductQuantitiesByProduct_Id(productId);
	}

	public ProductQuantity updateProductQuantity(ProductQuantity productQuantity) {
		return productQuantityRepository.save(productQuantity);
	}
}
