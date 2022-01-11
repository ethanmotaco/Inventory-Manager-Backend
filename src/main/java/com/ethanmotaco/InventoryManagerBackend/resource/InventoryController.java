/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.resource;

import org.springframework.web.bind.annotation.RestController;
import com.ethanmotaco.InventoryManagerBackend.model.InboundLog;
import com.ethanmotaco.InventoryManagerBackend.model.OutboundLog;
import com.ethanmotaco.InventoryManagerBackend.model.Product;
import com.ethanmotaco.InventoryManagerBackend.model.ProductQuantity;
import com.ethanmotaco.InventoryManagerBackend.model.ProductQuantityKey;
import com.ethanmotaco.InventoryManagerBackend.model.Store;
import com.ethanmotaco.InventoryManagerBackend.service.InboundLogService;
import com.ethanmotaco.InventoryManagerBackend.service.OutboundLogService;
import com.ethanmotaco.InventoryManagerBackend.service.ProductQuantityService;
import com.ethanmotaco.InventoryManagerBackend.service.ProductService;
import com.ethanmotaco.InventoryManagerBackend.service.StoreService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ethan Motaco
 *
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	private final StoreService storeService;
	private final ProductService productService;
	private final ProductQuantityService productQuantityService;
	private final InboundLogService inboundLogService;
	private final OutboundLogService outboundLogService;

	
	public InventoryController(StoreService storeService, 
			ProductService productService, 
			ProductQuantityService productQuantityService,
			InboundLogService inboundLogService, 
			OutboundLogService outboundLogService) {
		
		super();
		this.storeService = storeService;
		this.productService = productService;
		this.productQuantityService = productQuantityService;
		this.inboundLogService = inboundLogService;
		this.outboundLogService = outboundLogService;
	}
	
	
	//Quantity requests 
	
	@GetMapping("/quantity/all")
	public ResponseEntity<List<ProductQuantity>> findAllProductQuantities() {
		List<ProductQuantity> productQuantities = productQuantityService.findAllProductQuantities();
		return new ResponseEntity<>(productQuantities, HttpStatus.OK);
	}
	
	@GetMapping("/quantity/{storeId}")
	public ResponseEntity<List<ProductQuantity>> findProductQuantitiesByStoreId(@PathVariable("storeId") Long storeId) {
		List<ProductQuantity> productQuantities = productQuantityService.findProductQuantitiesByStoreId(storeId);
		return new ResponseEntity<>(productQuantities, HttpStatus.OK);
	}
	
	@PostMapping("/quantity/add")
	public ResponseEntity<ProductQuantity> addProductQuantity(@RequestBody ProductQuantity productQuantity) {
		productQuantity.setId(new ProductQuantityKey(productQuantity.getStore().getId(), productQuantity.getProduct().getId()));
		ProductQuantity newproductQuantity = productQuantityService.addProductQuantity(productQuantity);
		return new ResponseEntity<>(newproductQuantity, HttpStatus.CREATED);
	}
	
	@PutMapping("/quantity/update")
	public ResponseEntity<ProductQuantity> updateProductQuantity(@RequestBody ProductQuantity productQuantity) {
		ProductQuantityKey id = new ProductQuantityKey(productQuantity.getStore().getId(), productQuantity.getProduct().getId());
		productQuantity.setId(id);
		updateLogs(productQuantityService.findProductQuantityById(id), productQuantity);
		ProductQuantity updatedProductQuantity = productQuantityService.updateProductQuantity(productQuantity);
		return new ResponseEntity<>(updatedProductQuantity, HttpStatus.OK);
	}
	
	@DeleteMapping("/quantity/delete/{storeId}/{productId}")
	public ResponseEntity<?> deleteStoreById(@PathVariable("storeId") Long storeId, @PathVariable("productId") Long productId) {
		productQuantityService.deleteProductQuantityByStoreIdAndProductId(storeId, productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//Store requests
	
	@GetMapping("/store/all")
	public ResponseEntity<List<Store>> findAllStores () {
		List<Store> stores = storeService.findAllStores();
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/store/find/{id}")
	public ResponseEntity<Store> findStoreById (@PathVariable("id") Long id) {
		Store store = storeService.findStoreById(id);
		
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
	
	@PostMapping("/store/add")
	public ResponseEntity<Store> addStore(@RequestBody Store store) {
		Store newStore = storeService.addStore(store);
		return new ResponseEntity<>(newStore, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/store/delete/{id}")
	public ResponseEntity<?> deleteStoreById(@PathVariable("id") Long id) {
		productQuantityService.deleteProductQuantitiesByStoreId(id);
		storeService.deleteStoreById(id);
		inboundLogService.deleteInboundLogLogByStoreId(id);
		outboundLogService.deleteOutboundLogByStoreId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	//Product requests
	
	@GetMapping("/product/all")
	public ResponseEntity<List<Product>> findAllProducts () {
		List<Product> products = productService.findAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/product/findavailable/{storeId}")
	public ResponseEntity<List<Product>> findAvailableProductsByStoreId (@PathVariable("storeId") Long storeId) {
		List<Product> products = productService.findAvailableProductsByStoreId(storeId);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/product/find/{id}")
	public ResponseEntity<Product> findProductById (@PathVariable("id") Long id) {
		Product product = productService.findProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PostMapping("/product/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.addProduct(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/product/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updatedProduct = productService.addProduct(product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id) {
		productQuantityService.deleteProductQuantitiesByProductId(id);
		productService.deleteProductById(id);
		inboundLogService.deleteInboundLogLogByProductId(id);
		outboundLogService.deleteOutboundLogByProductId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//Log requests
	
	@GetMapping("/inboundLog/find/all")
	public ResponseEntity<List<InboundLog>> findAllInboundLogs () {
		List<InboundLog> logs = inboundLogService.findAllInboundLogs();
		return new ResponseEntity<>(logs, HttpStatus.OK);
	}
	
	@GetMapping("/inboundLog/find/{storeId}")
	public ResponseEntity<List<InboundLog>> findInboundLogsByStoreId (@PathVariable("storeId") Long storeId) {
		List<InboundLog> logs = inboundLogService.findInboundLogsByStoreId(storeId);
		return new ResponseEntity<>(logs, HttpStatus.OK);
	}
	
	@GetMapping("/outboundLog/find/all")
	public ResponseEntity<List<OutboundLog>> findAllOutboundLogs () {
		List<OutboundLog> logs = outboundLogService.findAllOutboundLogs();
		return new ResponseEntity<>(logs, HttpStatus.OK);
	}
	
	@GetMapping("/outboundLog/find/{storeId}")
	public ResponseEntity<List<OutboundLog>> findOutboundLogsByStoreId (@PathVariable("storeId") Long storeId) {
		List<OutboundLog> logs = outboundLogService.findOutboundLogsByStoreId(storeId);
		return new ResponseEntity<>(logs, HttpStatus.OK);
	}

	private void updateLogs(ProductQuantity oldProductQuantity, ProductQuantity newProductQuantity) {

		if(newProductQuantity.getQuantity() > oldProductQuantity.getQuantity()) {
			
			InboundLog newLog = new InboundLog();
			newLog.setProduct(newProductQuantity.getProduct().getName());
			newLog.setProductId(newProductQuantity.getProduct().getId());
			newLog.setStore(newProductQuantity.getStore().getName());
			newLog.setStoreId(newProductQuantity.getStore().getId());
			newLog.setTimestamp(dtf.format(LocalDateTime.now()));
			newLog.setQuantity(newProductQuantity.getQuantity() - oldProductQuantity.getQuantity());
			inboundLogService.addInboundLog(newLog);
			
		} else if(newProductQuantity.getQuantity() < oldProductQuantity.getQuantity()) {
			
			OutboundLog newLog = new OutboundLog();
			newLog.setProduct(newProductQuantity.getProduct().getName());
			newLog.setProductId(newProductQuantity.getProduct().getId());
			newLog.setStore(newProductQuantity.getStore().getName());
			newLog.setStoreId(newProductQuantity.getStore().getId());
			newLog.setTimestamp(dtf.format(LocalDateTime.now()));
			newLog.setQuantity(newProductQuantity.getQuantity() - oldProductQuantity.getQuantity());
			outboundLogService.addOutboundLog(newLog);
		}
	}

}
