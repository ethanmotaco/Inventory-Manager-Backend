package com.ethanmotaco.InventoryManagerBackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.ethanmotaco.InventoryManagerBackend.model.OutboundLog;

/**
 * @author Ethan Motaco
 *
 */
public interface OutboundLogRepository extends JpaRepository<OutboundLog, Long> {
	
	@Transactional
	void deleteOutboundLogByStoreId(Long storeId);

	@Transactional
	void deleteOutboundLogByProductId(Long productId);
	
	List<OutboundLog> findAllByStoreId(Long id);
	
}