/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ethanmotaco.InventoryManagerBackend.exception.StoreNotFoundException;
import com.ethanmotaco.InventoryManagerBackend.model.Store;
import com.ethanmotaco.InventoryManagerBackend.repository.StoreRepository;

/**
 * @author Ethan Motaco
 *
 */
@Service
public class StoreService {
	private final StoreRepository storeRepository;

	@Autowired
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}
	
	public Store addStore(Store store) {
		return storeRepository.save(store);
	}
	
	public List<Store> findAllStores() {
		return storeRepository.findAll();
	}
	
	public Store updateStore(Store store) {
		return storeRepository.save(store);
	}
	
	public void deleteStoreById(Long id) {
		storeRepository.deleteStoreById(id);
	}
	
	public Store findStoreById(Long id) {
		return storeRepository.findStoreById(id)
				.orElseThrow(() -> new StoreNotFoundException ("Store with id " + id + " was not found"));
	}

}
