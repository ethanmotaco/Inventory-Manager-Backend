/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ethanmotaco.InventoryManagerBackend.exception.ProductNotFoundException;
import com.ethanmotaco.InventoryManagerBackend.model.Product;
import com.ethanmotaco.InventoryManagerBackend.repository.ProductRepository;

/**
 * @author Ethan Motaco
 *
 */
@Service
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public List<Product> findProductsByIds(List<Long> ids) {
		return productRepository.findAllById(ids);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteProductById(id);
	}
	
	public Product findProductById(Long id) {
		return productRepository.findProductById(id)
				.orElseThrow(() -> new ProductNotFoundException ("Product with id " + id + " was not found"));
	}

	public List<Product> findAvailableProductsByStoreId(Long storeId) {
		return productRepository.findAvailableProductsByStoreId(storeId);
	}

}
