package com.ethanmotaco.InventoryManagerBackend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ethanmotaco.InventoryManagerBackend.model.Product;

/**
 * @author Ethan Motaco
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Transactional
	void deleteProductById(Long id);

	Optional<Product> findProductById(Long id);

	@Query(
		value = "SELECT * FROM product WHERE id NOT IN (SELECT product_id FROM product_quantity WHERE store_id = :storeId)",
		nativeQuery = true)
	List<Product> findAvailableProductsByStoreId(@Param("storeId") Long storeId);
}
