/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.ethanmotaco.InventoryManagerBackend.model.Store;

/**
 * @author Ethan Motaco
 *
 */
public interface StoreRepository extends JpaRepository<Store, Long> {
	
	@Transactional
	void deleteStoreById(Long id);

	Optional<Store> findStoreById(Long id);
	
}
