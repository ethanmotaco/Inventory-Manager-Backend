/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ethanmotaco.InventoryManagerBackend.model.OutboundLog;
import com.ethanmotaco.InventoryManagerBackend.repository.OutboundLogRepository;

/**
 * @author Ethan Motaco
 *
 */
@Service
public class OutboundLogService  {
	private final OutboundLogRepository outboundLogRepository;

	@Autowired
	public OutboundLogService(OutboundLogRepository outboundLogRepository) {
		this.outboundLogRepository = outboundLogRepository;
	}
	
	public List<OutboundLog> findAllOutboundLogs() {
		return outboundLogRepository.findAll();
	}
	
	public List<OutboundLog> findOutboundLogsByStoreId(Long storeId) {
		return outboundLogRepository.findAllByStoreId(storeId);
	}
	
	public OutboundLog addOutboundLog(OutboundLog log) {
		return outboundLogRepository.save(log);
	}
	
	public void deleteOutboundLogByStoreId(Long storeId) {
		outboundLogRepository.deleteOutboundLogByStoreId(storeId);
	}
	
	public void deleteOutboundLogByProductId(Long productId) {
		outboundLogRepository.deleteOutboundLogByProductId(productId);
	}

}