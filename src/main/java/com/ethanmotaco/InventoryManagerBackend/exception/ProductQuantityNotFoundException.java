/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.exception;

/**
 * @author Ethan Motaco
 *
 */
public class ProductQuantityNotFoundException extends RuntimeException{

	public ProductQuantityNotFoundException(String message) {
		super(message);
	}
}
