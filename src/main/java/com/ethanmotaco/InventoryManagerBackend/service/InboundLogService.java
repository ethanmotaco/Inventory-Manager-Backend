/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ethanmotaco.InventoryManagerBackend.model.InboundLog;
import com.ethanmotaco.InventoryManagerBackend.repository.InboundLogRepository;

/**
 * @author Ethan Motaco
 *
 */
@Service
public class InboundLogService {
	
	private final InboundLogRepository inboundLogRepository;

	@Autowired
	public InboundLogService(InboundLogRepository inboundLogRepository) {
		this.inboundLogRepository = inboundLogRepository;
	}
	
	public List<InboundLog> findAllInboundLogs() {
		return inboundLogRepository.findAll();
	}
	
	public List<InboundLog> findInboundLogsByStoreId(Long storeId) {
		return inboundLogRepository.findAllByStoreId(storeId);
	}
	
	public InboundLog addInboundLog(InboundLog log) {
		return inboundLogRepository.save(log);
	}
	
	public void deleteInboundLogLogByStoreId(Long storeId) {
		inboundLogRepository.deleteInboundLogLogByStoreId(storeId);
	}
	
	public void deleteInboundLogLogByProductId(Long productId) {
		inboundLogRepository.deleteInboundLogLogByProductId(productId);
	}

}
