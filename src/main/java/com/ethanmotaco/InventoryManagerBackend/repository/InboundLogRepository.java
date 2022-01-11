
package com.ethanmotaco.InventoryManagerBackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.ethanmotaco.InventoryManagerBackend.model.InboundLog;

/**
 * @author Ethan Motaco
 *
 */
public interface InboundLogRepository extends JpaRepository<InboundLog, Long> {
	
	@Transactional
	void deleteInboundLogLogByStoreId(Long storeId);

	@Transactional
	void deleteInboundLogLogByProductId(Long productId);
	
	List<InboundLog> findAllByStoreId(Long id);
	
}